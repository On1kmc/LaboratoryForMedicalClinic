package com.ivanov.laboratory.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Client {


    private int id;

    private String name;


    private String surname;

    private Date dateOfBirth;

    private List<Order> orderList;

}
