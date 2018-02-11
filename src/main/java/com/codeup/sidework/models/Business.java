package com.codeup.sidework.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "businesses")
public class Business {
    //id
    @Id @GeneratedValue
    private long id;

    @Column
    private String businessName;

    //phone number
    @Column
    private String businessPhone;
    //website
    @Column
    private String website;

    //address
    @Column
    private String address;

    //info
    @Column
    private String businessInfo;

    @OneToOne
    private User user;

    // this is connecting to the listings table.
    // for any one business this returns a list of all it's job listings
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<Listing> listings;


    public Business(long id, String businessName, String businessPhone, String website, String address, String businessInfo, User user) {
        this.id = id;
        this.businessName = businessName;
        this.businessPhone = businessPhone;
        this.website = website;
        this.address = address;
        this.businessInfo = businessInfo;
        this.user = user;
    }

    public Business() {

    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
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

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
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
}
