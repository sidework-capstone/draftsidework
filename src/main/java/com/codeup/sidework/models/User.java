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

    @OneToOne
    private Business business;

    @OneToOne
    private Worker worker;

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;
        this.business = copy.business;
        this.worker = copy.worker;
    }

    public User() {}

    public User(String username, String email, String password, Business business, Worker worker) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.business = business;
        this.worker = worker;
    }

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

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public User(Worker worker) {
        this.worker = worker;
    }

    public User(Business business) {

        this.business = business;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
