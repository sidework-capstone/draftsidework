package com.codeup.sidework.models;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "division")
public class Division {

    //id
    @Id @GeneratedValue
    private long id;

    //division name
    // floor bar / kitchen support / owners mgmt
    @Column(nullable = false)
    private String divisionName;


    // creates a department_division pivot table
    // connected to Division class
    @ManyToOne
    @JoinColumn (name = "department_id")
    private Department department;


    // creates a positions_division pivot table
    // connecting Positions class creating join table
    @ManyToMany(mappedBy = "divisions")
    private List<Positions> positions;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }


    public Division(String divisionName) {
        this.divisionName = divisionName;
    }

    public Division() {

    }
}