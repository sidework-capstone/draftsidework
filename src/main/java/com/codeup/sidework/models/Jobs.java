package com.codeup.sidework.models;


import org.apache.tomcat.jni.Time;
import org.hibernate.type.DateType;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private DateType shiftDate;

        // Number of shifts per posting
    @Column(nullable = false)
    private int shiftQuantity;

    //shift start time
    @Column(nullable = false)
    private LocalDateTime startTime;

    //shift end time
    @Column(nullable = false)
    private LocalDateTime endTime;

    //shift details
    @Column(nullable = false)
    private String description;

    // this is connecting to the business table.
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public Jobs() {

    }

}
