package com.ateeq.Java_Prj1.service;

import com.ateeq.Java_Prj1.model.Customer;
import com.ateeq.Java_Prj1.model.Earnings;
import com.ateeq.Java_Prj1.model.Menu;
import com.ateeq.Java_Prj1.model.Order;
import com.ateeq.Java_Prj1.repository.CustomerRepository;
import com.ateeq.Java_Prj1.repository.EarningsRepository;
import com.ateeq.Java_Prj1.repository.MenuRepository;
import com.ateeq.Java_Prj1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EarningsRepository earningsRepository;

    public String placeOrder(int customerId, int menuItemId, int quantityOrdered) {

        // 1. Find customer by id
        Customer customer = customerRepository.findById(customerId).orElse(null);

        if (customer == null) {
            return "Customer Not Found";
        }

        // 2. Find menu item by id
        Menu menuItem = menuRepository.findById(menuItemId).orElse(null);

        if (menuItem == null) {
            return "Menu Item Not Found";
        }

        // 3. Check quantity is valid
        if (quantityOrdered <= 0) {
            return "Quantity must be greater than 0";
        }

        // 4. Check item stock is 0
        if (menuItem.getQuantityAvailable() == 0) {
            return "Item is out of stock";
        }

        // 5. Check customer ordered more than available stock
        if (quantityOrdered > menuItem.getQuantityAvailable()) {
            return "Not enough stock";
        }

        // 6. Calculate total price
        int totalPrice = menuItem.getPrice() * quantityOrdered;

        // 7. Reduce stock
        int newStock = menuItem.getQuantityAvailable() - quantityOrdered;
        menuItem.setQuantityAvailable(newStock);

        // 8. Save updated menu item
        menuRepository.save(menuItem);

        // 9. Create new order
        Order order = new Order();
        order.setCustomer(customer);
        order.setMenuItem(menuItem);
        order.setQuantityOrdered(quantityOrdered);
        order.setTotalPrice(totalPrice);

        // 10. Save order
        orderRepository.save(order);

        Earnings earn = earningsRepository.findById(1).orElse(null);

        if (earn == null) {
            earn = new Earnings();
            earn.setId(1);
            earn.setTotalEarnings(0);
        }

        int oldEarnings = earn.getTotalEarnings();

        int newEarnings = oldEarnings + totalPrice;

        earn.setTotalEarnings(newEarnings);

        earningsRepository.save(earn);

        return "Order placed successfully. Total Price = " + totalPrice;
    }
}