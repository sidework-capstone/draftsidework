package com.codeup.sidework.models;


import org.hibernate.type.DateType;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user_positions")
public class UserPositions implements Serializable {


// CREATES A USERS_POSITIONS PIVOT TABLE//
//===============connected to USER class//
    @Id
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

//==========connected to POSITIONS class//
    @Id
    @ManyToOne
    @JoinColumn (name = "positions_id")
    private Positions position;


    //duration for position held - start date of that job title
    @Column
    private DateType startDate;

    //duration for position held - final date of that job title
    @Column
    private DateType stopDate;
//======================================//




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
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
