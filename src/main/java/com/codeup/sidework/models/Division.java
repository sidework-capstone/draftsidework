package com.codeup.sidework.models;


import javax.persistence.*;


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



    public Division() {

    }
}
