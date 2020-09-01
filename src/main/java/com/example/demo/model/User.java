package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;

@Data
@Entity
public class User {


    @Id
    private int id;

    private String name;

    private String surname;

    private String username;

    //private Set<Authority> authorities;


}
