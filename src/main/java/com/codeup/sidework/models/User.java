package com.codeup.sidework.models;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserPositions> userPositions;

    //id
    @Id @GeneratedValue
    private long id;

    //username
    @Column(nullable = false)
    private String username;

    //email
    @Column(nullable = false)
    private String email;

    //password
    @Column(nullable = false)
    private String password;

    //phone
    @Column(nullable = false)
    private int phone;

    //bio
    @Column
    private String bio;

    //skills
    @Column
    private String skills;

    //currentEmployment
    @Column
    private boolean currentEmployment;

    //availability
    @Column
    private boolean availability;

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

    // this is connecting to the business table.
    // creating a list of businesses associate with a user
    @ManyToMany(mappedBy = "users")
    private List<Business> businesses;


    // this creates a user_positions pivot table
    // connected to UserPositions class

    public List<UserPositions> getUserPositions() {
        return userPositions;
    }

    public void setUserPositions(List<UserPositions> userPositions) {
        this.userPositions = userPositions;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public boolean isCurrentEmployment() {
        return currentEmployment;
    }

    public void setCurrentEmployment(boolean currentEmployment) {
        this.currentEmployment = currentEmployment;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
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

    public User(String username, String email, String password, int phone, String bio, String skills, boolean currentEmployment, boolean availability, String facebook, String twitter, String linkedIn, String instagram) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.bio = bio;
        this.skills = skills;
        this.currentEmployment = currentEmployment;
        this.availability = availability;
        this.facebook = facebook;
        this.twitter = twitter;
        this.linkedIn = linkedIn;
        this.instagram = instagram;
    }

    public User(){

    }

}
