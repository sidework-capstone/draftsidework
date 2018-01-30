package com.codeup.sidework.models;


import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "positions")
public class Positions {
    private Set<UserPositions> userPositions;

    //id
    @Id @GeneratedValue
    private long id;

    //jobTitle
    @Column(nullable = false)
    private String jobTitle;




    // this creates a user_positions pivot table
    // connected to UserPositions class
    @OneToMany(mappedBy = "positions")
    public Set<UserPositions> getUserPositions() {
        return userPositions;
    }

    public void setUserPositions(Set<UserPositions> userPositions) {
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
