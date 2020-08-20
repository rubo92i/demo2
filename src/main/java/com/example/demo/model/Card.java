package com.example.demo.model;


import lombok.Data;

@Data
public class Card {

    private int id;


    private String number;


    private String holder;

    private String cvv;

    private double balance;
}
