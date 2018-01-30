package com.codeup.sidework.models;


import org.apache.tomcat.jni.Time;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "jobs")
public class Jobs {

    //id
    @Id @GeneratedValue
    private long id;

    //listingTitle
    @Column(nullable = false)
    private String jobListingTitle;

    //pay
    @Column(nullable = false)
    private int pay;

        // Number of persons needed for a shift
    @Column(nullable = false)
    private int requiredLabor;

    //date of shift
    @Column(nullable = false)
    private Date shiftDate;

        // Number of shifts per posting
    @Column(nullable = false)
    private int shiftQuantity;

    //shift start time
    @Column(nullable = false)
    private Time startTime;

    //shift end time
    @Column(nullable = false)
    private Time endTime;

    //shift details
    @Column(nullable = false)
    private String description;

//    // this is connecting to the business table.
//    // creates a
//    @ManyToOne
//    @JoinColumn (name = "business_id")
//    private Business business;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobListingTitle() {
        return jobListingTitle;
    }

    public void setJobListingTitle(String jobListingTitle) {
        this.jobListingTitle = jobListingTitle;
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

    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }

    public int getShiftQuantity() {
        return shiftQuantity;
    }

    public void setShiftQuantity(int shiftQuantity) {
        this.shiftQuantity = shiftQuantity;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Jobs(String jobListingTitle, int pay, int requiredLabor, Date shiftDate, int shiftQuantity, Time startTime, Time endTime, String description) {
        this.jobListingTitle = jobListingTitle;
        this.pay = pay;
        this.requiredLabor = requiredLabor;
        this.shiftDate = shiftDate;
        this.shiftQuantity = shiftQuantity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public Jobs() {

    }

}
