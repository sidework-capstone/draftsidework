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

    //id
    @Id
    @GeneratedValue
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

    //facebook
    @Column
    private String facebook;

    //twitter
    @Column
    private String twitter;

    //linkedin
    @Column
    private String linkedIn;

    //instagram
    @Column
    private String instagram;

    // this is connecting to the user table.
    // creates a list of all employees associated with that business
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "business_users",
            joinColumns = {@JoinColumn(name = "business_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> users;


    public List<Listings> getListings() {
        return listings;
    }

    public void setListings(List<Listings> listings) {
        this.listings = listings;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public Business(List<User> users) {
        this.users = users;
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

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }


    public Business(String businessName, String email, int businessPhone, String website, String address,
                    String businessInfo, String facebook, String twitter, String linkedIn, String instagram) {
        this.businessName = businessName;
        this.email = email;
        this.businessPhone = businessPhone;
        this.website = website;
        this.address = address;
        this.businessInfo = businessInfo;
        this.facebook = facebook;
        this.twitter = twitter;
        this.linkedIn = linkedIn;
        this.instagram = instagram;
    }

    public Business(Business copy) {
        this.id = copy.id;
        this.businessName = copy.businessName;
        this.email = copy.email;
        this.businessPhone = copy.businessPhone;
        this.website = copy.website;
        this.address = copy.address;
        this.businessInfo = copy.businessInfo;
        this.facebook = copy.facebook;
        this.twitter = copy.twitter;
        this.linkedIn = copy.linkedIn;
        this.instagram = copy.instagram;
    }

    public Business() {

    }

    @Override
    public String toString() {
        return String.format(
                "Business[businessName='%s', id=%d, businessEmail='%s']",
                businessName, id, email);
    }
}
