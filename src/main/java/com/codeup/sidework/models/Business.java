package com.codeup.sidework.models;

import javax.persistence.*;


@Entity
@Table(name = "business")
public class Business {

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

    //address
    @Column(nullable = false)
    private String address;

    //website
    @Column(nullable = false)
    private String website;

    //account_mgr
    @Column(nullable = false)
    private String accountManager;

    //info
    @Column(nullable = false)
    private String businessInfo;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
//    @JsonBackReference
//    private List<Jobs> jobs;
//
//    @ManytoMany(cascade = CascadeType.ALL, mappedBy = "employees")
//    @JsonBackReference
//    private List<User> users;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public Business(String businessName, String businessEmail, String password, String address, String website, String accountManager, String businessInfo) {
        this.businessName = businessName;
        this.businessEmail = businessEmail;
        this.password = password;
        this.address = address;
        this.website = website;
        this.accountManager = accountManager;
        this.businessInfo = businessInfo;
    }

    public Business(){

    }

}
