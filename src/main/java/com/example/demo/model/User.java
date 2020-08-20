package com.example.demo.model;

import lombok.Data;


import java.util.List;
import java.util.Set;

@Data
public class User {


    private int id;

    private String name;

    private String surname;

    private String username;

    private Set<Authority> authorities;


}
