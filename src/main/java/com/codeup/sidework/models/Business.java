package com.codeup.sidework.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "business")
public class Business {
    // this is connecting to the listings table.
    // for any one business this returns a list of all it's job listings
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<Listings> jobs;

    //id
    @Id @GeneratedValue
    private long id;

    //name
    @Column(nullable = false)
    private String businessName;

    //email
    @Column(nullable = false)
    private String businessEmail;

    //password
    @Column(nullable = false)
    private String password;

    //phone number
    @Column
    private int businessPhone;

    //website
    @Column(nullable = false)
    private String website;

    //address
    @Column(nullable = false)
    private String address;

    //info
    @Column(nullable = false)
    private String businessInfo;

    //account_mgr
    @Column
    private String accountManager;

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
            name="business_users",
            joinColumns = {@JoinColumn(name="business_id")},
            inverseJoinColumns = {@JoinColumn(name="user_id")}
    )
    private List<User> users;


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

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
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

    public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
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

    public List<Listings> getJobs() {
        return jobs;
    }

    public void setJobs(List<Listings> jobs) {
        this.jobs = jobs;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Business(List<Listings> jobs) {
        this.jobs = jobs;
    }

    public Business(String businessName, String businessEmail, String password, int businessPhone, String website, String address, String accountManager, String businessInfo, String facebook, String twitter, String linkedIn, String instagram) {
        this.businessName = businessName;
        this.businessEmail = businessEmail;
        this.password = password;
        this.businessPhone = businessPhone;
        this.website = website;
        this.address = address;
        this.accountManager = accountManager;
        this.businessInfo = businessInfo;
        this.facebook = facebook;
        this.twitter = twitter;
        this.linkedIn = linkedIn;
        this.instagram = instagram;
    }


    public Business() {

    }

    @Override
    public String toString() {
        return String.format(
                "Business[businessName='%s', id=%d, businessEmail='%s', website='%s', address='%s', businessInfo='%s']",
                businessName, id, businessEmail, website, address, businessInfo);
    }


}
