package com.codeup.sidework.models;

import javax.persistence.*;


@Entity
@Table(name = "department")
public class Department {

    //id
    @Id @GeneratedValue
    private long id;

    //name
    @Column(nullable = false)
    private String departmentName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(){

    }
}
