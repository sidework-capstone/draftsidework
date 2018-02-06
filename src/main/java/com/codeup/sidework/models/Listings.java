package com.codeup.sidework.models;


import org.apache.tomcat.jni.Time;
import org.hibernate.type.DateType;
import org.hibernate.type.TimeType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "listings")
public class Listings {

    //id
    @Id @GeneratedValue
    private long id;

    //shift details
    @Column(nullable = false)
    private String description;


    // connected to the positions table
    // many job listings can be associated with many positions
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="listing_positions",
            joinColumns={@JoinColumn(name="listings_id")},
            inverseJoinColumns={@JoinColumn(name="positions_id")}
    )
    private List<Positions> positions;


    // connected to the business table.
    // many job postings can be associated with a business by the id
    @ManyToOne
    @JoinColumn (name = "business_id")
    private Business business;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public List<Positions> getPositions() {
        return positions;
    }

    public void setPositions(List<Positions> positions) {
        this.positions = positions;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }




    public Listings(List<Positions> positions) {
        this.positions = positions;
    }


    public Listings(String description) {
        this.description = description;
    }

    public Listings() {

    }

}
