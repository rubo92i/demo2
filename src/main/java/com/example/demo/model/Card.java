package com.example.demo.model;



 public class Card {

    private int id;


    private String number;


    private String holder;

    private String cvv;

    private double balance;

     public void setId(int id) {
         this.id = id;
     }

     public void setNumber(String number) {
         this.number = number;
     }

     public void setHolder(String holder) {
         this.holder = holder;
     }

     public void setCvv(String cvv) {
         this.cvv = cvv;
     }

     public void setBalance(double balance) {
         this.balance = balance;
     }
 }
