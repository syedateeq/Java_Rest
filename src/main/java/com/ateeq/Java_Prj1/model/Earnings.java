package com.ateeq.Java_Prj1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Earnings {

    @Id
    private int id;

    private int totalEarnings;
}