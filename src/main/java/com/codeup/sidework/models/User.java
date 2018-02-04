package com.codeup.sidework.models;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    // this creates a user_positions pivot table
    // connected to USERPOSITIONS class
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserPositions> userPositions;


    //id
    @Id
    @GeneratedValue
    private long id;

    //username
    @Column(nullable = false, unique = true)
    private String username;

    //first name
    @Column(nullable = false)
    private String firstName;

    //last name
    @Column(nullable = false)
    private String lastName;

    //email
    @Column(nullable = false, unique = true)
    private String email;

    //password
    @Column(nullable = false)
    private String password;

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

    // this is connecting to the business table.
    // creating a list of businesses associate with a user
    @ManyToMany(mappedBy = "users")
    private List<Business> businesses;





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





    public void setUserPositions(List<UserPositions> userPositions) {
        this.userPositions = userPositions;
    }

    public List<UserPositions> getUserPositions() {
        return userPositions;
    }

//    public User(List<UserPositions> userPositions) {
//        this.userPositions = userPositions;
//    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public User(List<Business> businesses) {
        this.businesses = businesses;
    }



    public User(String username, String firstName, String lastName, String email, String password, int phone, String bio, String skills, boolean currentEmployment, boolean availability, String facebook, String twitter, String linkedIn, String instagram) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.email = copy.email;
        this.password = copy.password;
        this.phone = copy.phone;
        this.bio = copy.bio;
        this.skills = copy.skills;
        this.currentEmployment = copy.currentEmployment;
        this.availability = copy.availability;
        this.facebook = copy.facebook;
        this.twitter = copy.twitter;
        this.linkedIn = copy.linkedIn;
        this.instagram = copy.instagram;
    }

    public User() {

    }

    @Override
    public String toString() {
        return String.format(
                "User[username='%s', id=%d, firstName='%s', lastName='%s']",
                username, id, firstName, lastName);
    }

}

