package com.ivanov.laboratory.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "analyzes")
public class Analyze {

    String name;
    String description;

    @Id
    public int id;


}

