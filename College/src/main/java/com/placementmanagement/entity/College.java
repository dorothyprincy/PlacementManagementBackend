package com.placementmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="college")
public class College {
    @Id
    private Long id;
    private  String collegename;
    private String location;

    public College() {
    }

    public College(Long id, String collegename, String location) {
        this.id = id;
        this.collegename = collegename;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", collegename='" + collegename + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

