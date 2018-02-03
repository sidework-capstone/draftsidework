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

    //pay
    @Column(nullable = false)
    private int pay;

        // Number of persons needed for a shift
    @Column(nullable = false)
    private int requiredLabor;

    //date of shift
    @Column(nullable = false)
    private DateType shiftDate;

        // Number of shifts per posting
    @Column(nullable = false)
    private int shiftQuantity;

    //shift start time
    @Column(nullable = false)
    private TimeType startTime;

    //shift end time
    @Column(nullable = false)
    private TimeType endTime;

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

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getRequiredLabor() {
        return requiredLabor;
    }

    public void setRequiredLabor(int requiredLabor) {
        this.requiredLabor = requiredLabor;
    }

    public DateType getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(DateType shiftDate) {
        this.shiftDate = shiftDate;
    }

    public int getShiftQuantity() {
        return shiftQuantity;
    }

    public void setShiftQuantity(int shiftQuantity) {
        this.shiftQuantity = shiftQuantity;
    }

    public TimeType getStartTime() {
        return startTime;
    }

    public void setStartTime(TimeType startTime) {
        this.startTime = startTime;
    }

    public TimeType getEndTime() {
        return endTime;
    }

    public void setEndTime(TimeType endTime) {
        this.endTime = endTime;
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

    public Listings(int pay, int requiredLabor, DateType shiftDate, int shiftQuantity, TimeType startTime, TimeType endTime, String description) {
        this.pay = pay;
        this.requiredLabor = requiredLabor;
        this.shiftDate = shiftDate;
        this.shiftQuantity = shiftQuantity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public Listings() {

    }

}
