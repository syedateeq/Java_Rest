package com.ateeq.Java_Prj1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private int id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Menu menuItem;

    private int quantityOrdered;
    private int totalPrice;
}