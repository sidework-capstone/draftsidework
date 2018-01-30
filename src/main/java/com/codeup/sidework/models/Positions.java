package com.codeup.sidework.models;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "positions")
public class Positions {


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
    @ManyToMany
    @JoinTable(
            name="positions_division",
            joinColumns = {@JoinColumn(name="positions_id")},
            inverseJoinColumns = {@JoinColumn(name="division_id")}
    )
    private List<Division> divisions;


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
}
