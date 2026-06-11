package com.ateeq.Java_Prj1.Controller;

import com.ateeq.Java_Prj1.model.Customer;
import com.ateeq.Java_Prj1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Add new customer
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}