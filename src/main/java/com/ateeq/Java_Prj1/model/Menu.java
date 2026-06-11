package com.ateeq.Java_Prj1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "menu_item")
public class Menu {
    @Id
    private int id;
    private String itemName;
    private int price;
    private int quantityAvailable;

}
