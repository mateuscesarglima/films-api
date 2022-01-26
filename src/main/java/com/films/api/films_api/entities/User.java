package com.films.api.films_api.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class User implements Serializable{

    private Integer id;

    private String name;

    private String email;

    private String password;

    private Instant bornDate;

    
}
