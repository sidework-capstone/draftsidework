package com.codeup.sidework.models;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {


    //id
    @Id
    @GeneratedValue
    private long id;

    //username
    @Column(nullable = false, unique = true)
    private String username;


    //email
    @Column(nullable = false, unique = true)
    private String email;

    //password
    @Column(nullable = false)
    private String password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;
    }

    public User() {

    }

}

