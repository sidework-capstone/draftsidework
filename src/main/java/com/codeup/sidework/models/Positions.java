package com.codeup.sidework.models;


import javax.persistence.*;


@Entity
@Table(name = "positions")
public class Positions {

    //id
    @Id @GeneratedValue
    private long id;

    //jobTitle
    @Column(nullable = false)
    private String jobTitle;

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
