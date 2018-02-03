package com.codeup.sidework.models;


import javax.persistence.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.util.List;


@Entity
@Table(name = "positions")
public class Positions implements PropertyEditor {
    String [] floorJobsPath;
    String [] kitchenJobsPath;
    String [] supportJobsPath;
    String [] operatorJobsPath;


    // creates a user_positions pivot table
    // connected to UserPositions class
    @OneToMany(mappedBy = "position")
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



    public List<UserPositions> getUserPositions() {
        return userPositions;
    }

    public void setUserPositions(List<UserPositions> userPositions) {
        this.userPositions = userPositions;
    }

    public String[] getFloorJobsPath() {
        return floorJobsPath;
    }

    public void setFloorJobsPath(String[] floorJobsPath) {
        this.floorJobsPath = floorJobsPath;
    }

    public String[] getKitchenJobsPath() {
        return kitchenJobsPath;
    }

    public void setKitchenJobsPath(String[] kitchenJobsPath) {
        this.kitchenJobsPath = kitchenJobsPath;
    }

    public String[] getSupportJobsPath() {
        return supportJobsPath;
    }

    public void setSupportJobsPath(String[] supportJobsPath) {
        this.supportJobsPath = supportJobsPath;
    }

    public String[] getOperatorJobsPath() {
        return operatorJobsPath;
    }

    public void setOperatorJobsPath(String[] operatorJobsPath) {
        this.operatorJobsPath = operatorJobsPath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }



    public Positions(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Positions() {

    }

    @Override
    public void setValue(Object value) {

    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public boolean isPaintable() {
        return false;
    }

    @Override
    public void paintValue(Graphics gfx, Rectangle box) {

    }

    @Override
    public String getJavaInitializationString() {
        return null;
    }

    @Override
    public String getAsText() {
        return null;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

    }

    @Override
    public String[] getTags() {
        return new String[0];
    }

    @Override
    public Component getCustomEditor() {
        return null;
    }

    @Override
    public boolean supportsCustomEditor() {
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }
}
