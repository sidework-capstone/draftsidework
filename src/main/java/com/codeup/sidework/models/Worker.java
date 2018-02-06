package com.codeup.sidework.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue
    private long id;

    //first name
    @Column(nullable = false)
    private String firstName;

    //last name
    @Column(nullable = false)
    private String lastName;

    //phone
    @Column
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserPositions> userPositions;

    @OneToOne
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
