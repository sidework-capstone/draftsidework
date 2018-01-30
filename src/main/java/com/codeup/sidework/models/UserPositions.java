package com.codeup.sidework.models;


import org.hibernate.type.DateType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user_positions")
public class UserPositions implements Serializable {
    private User user;
    private Positions positions;

    //id
    @Id @GeneratedValue
    private long id;

    //duration for position held - start date of that job title
    @Column
    private DateType startDate;

    //duration for position held - final date of that job title
    @Column
    private DateType stopDate;



// CREATES A USERS_POSITIONS PIVOT TABLE
//
    // connected to USER class
    @Id
    @ManyToOne
    @JoinColumn (name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // connected to POSITIONS class
    @Id
    @ManyToOne
    @JoinColumn (name = "positions_id")
    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions positions) {
        this.positions = positions;
    }
//
//



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DateType getStartDate() {
        return startDate;
    }

    public void setStartDate(DateType startDate) {
        this.startDate = startDate;
    }

    public DateType getStopDate() {
        return stopDate;
    }

    public void setStopDate(DateType stopDate) {
        this.stopDate = stopDate;
    }


    public UserPositions(DateType startDate, DateType stopDate) {
        this.startDate = startDate;
        this.stopDate = stopDate;
    }

    public UserPositions (){

    }
}
