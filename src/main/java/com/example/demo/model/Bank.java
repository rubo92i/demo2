package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(cascade = {CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.REFRESH},orphanRemoval = true)
    @JoinColumn(name = "bank_id")
    private List<Branch> branches;
}
