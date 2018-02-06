package com.codeup.sidework.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "business")
public class Business {
    // this is connecting to the listings table.
    // for any one business this returns a list of all its job listings
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<Listings> listings;

    public Business(List<Listings> listings) {
        this.listings = listings;
    }

    @OneToOne
    private User business;

    //id
    @Id @GeneratedValue
    private long id;

    //business name
    @Column(nullable = false, unique = true)
    private String businessName;

    //email
    @Column(nullable = false, unique = true)
    private String email;

    //phone number
    @Column
    private int businessPhone;

    //website
    @Column
    private String website;

    //address
    @Column
    private String address;

    //info
    @Column
    private String businessInfo;

    //user
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;


    public List<Listings> getListings() {
        return listings;
    }

    public void setListings(List<Listings> listings) {
        this.listings = listings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(int businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(String businessInfo) {
        this.businessInfo = businessInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Business(User user) {
        this.user = user;
    }

    public Business() {

    }
}
