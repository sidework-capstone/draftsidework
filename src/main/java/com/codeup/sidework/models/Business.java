package com.codeup.sidework.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "business")
public class Business {
    // this is connecting to the listings table.
    // for any one business this returns a list of all it's job listings
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

    //username
    @Column(nullable = false, unique = true)
    private String userName;

    //email
    @Column(nullable = false, unique = true)
    private String email;

    //password
    @Column(nullable = false)
    private String password;

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





    public List<Listings> getListings() {
        return listings;
    }

    public void setListings(List<Listings> listings) {
        this.listings = listings;
    }


    public User getBusiness() {
        return business;
    }

    public void setBusiness(User business) {
        this.business = business;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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


    public Business(User business) {
        this.business = business;
    }

    public Business(String userName, String email, String password, int businessPhone, String website, String address, String businessInfo) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.businessPhone = businessPhone;
        this.website = website;
        this.address = address;
        this.businessInfo = businessInfo;
    }

    public Business(Business copy) {
        this.id = copy.id;
        this.userName = copy.userName;
        this.email = copy.email;
        this.password = copy.password;
        this.businessPhone = copy.businessPhone;
        this.website = copy.website;
        this.address = copy.address;
        this.businessInfo = copy.businessInfo;
    }

    public Business() {

    }

    @Override
    public String toString() {
        return String.format(
                "Business[usernameName='%s', id=%d, businessEmail='%s']",
                userName, id, email);
    }


}
