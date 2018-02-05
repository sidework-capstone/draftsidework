package com.codeup.sidework.models;


import javax.persistence.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.util.List;


@Entity
@Table(name = "positions")
public class Positions {
    List<String> floor;
    List<String> bar;
    List<String> kitchen;
    List<String> support;
    List<String> operators;


    // creates a user_positions pivot table
    // connected to USERPOSITIONS class
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position")
    private List<UserPositions> userPositions;

    //id
    @Id @GeneratedValue
    private long id;

    //jobTitle
    @Column(nullable = false)
    private String jobTitle;


    // creates a positions_division pivot table
    // connecting Division class creating join table
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="positions_division",
            joinColumns = {@JoinColumn(name="positions_id")},
            inverseJoinColumns = {@JoinColumn(name="division_id")}
    )
    private List<Division> divisions;


    // connected to the listings table
    // many positions can be associated with many job listings
    @ManyToMany(mappedBy = "positions")
    private List<Listings> listings;


    public List<String> getFloor() {
        return floor;
    }

    public void setFloor(List<String> floor) {
        this.floor = floor;
    }

    public List<String> getBar() {
        return bar;
    }

    public void setBar(List<String> bar) {
        this.bar = bar;
    }

    public List<String> getKitchen() {
        return kitchen;
    }

    public void setKitchen(List<String> kitchen) {
        this.kitchen = kitchen;
    }

    public List<String> getSupport() {
        return support;
    }

    public void setSupport(List<String> support) {
        this.support = support;
    }

    public List<String> getOperators() {
        return operators;
    }

    public void setOperators(List<String> operators) {
        this.operators = operators;
    }


    public Positions(List<String> floor, List<String> bar, List<String> kitchen, List<String> support, List<String> operators) {
        this.floor = floor;
        this.bar = bar;
        this.kitchen = kitchen;
        this.support = support;
        this.operators = operators;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setDivisions(List<Division> divisions) {
        this.divisions = divisions;
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    public void setUserPositions(List<UserPositions> userPositions) {
        this.userPositions = userPositions;
    }

    public List<UserPositions> getUserPositions() {
        return userPositions;
    }

    public Positions(List<UserPositions> userPositions) {
        this.userPositions = userPositions;
    }

    public void setListings(List<Listings> listings) {
        this.listings = listings;
    }

    public List<Listings> getListings() {
        return listings;
    }





    public Positions(List<Division> divisions) {
        this.divisions = divisions;
    }

    public Positions(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Positions() {

    }

//    @Override
//    public void setValue(Object value) {
//
//    }
//
//    @Override
//    public Object getValue() {
//        return null;
//    }
//
//    @Override
//    public boolean isPaintable() {
//        return false;
//    }
//
//    @Override
//    public void paintValue(Graphics gfx, Rectangle box) {
//
//    }
//
//    @Override
//    public String getJavaInitializationString() {
//        return null;
//    }
//
//    @Override
//    public String getAsText() {
//        return null;
//    }
//
//    @Override
//    public void setAsText(String text) throws IllegalArgumentException {
//
//    }
//
//    @Override
//    public String[] getTags() {
//        return new String[0];
//    }
//
//    @Override
//    public Component getCustomEditor() {
//        return null;
//    }
//
//    @Override
//    public boolean supportsCustomEditor() {
//        return false;
//    }
//
//    @Override
//    public void addPropertyChangeListener(PropertyChangeListener listener) {
//
//    }
//
//    @Override
//    public void removePropertyChangeListener(PropertyChangeListener listener) {
//
//    }
}
