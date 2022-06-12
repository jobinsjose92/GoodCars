package com.ourproject.GoodCars.Model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class cars {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long number;
    private String name;
    private String year;
    private String model;
    private String photo;


    //constructor

    public cars() {
    }

    public cars(long number,String name, String year, String model) {
        this.number = number;
        this.name = name;
        this.year = year;
        this.model = model;

    }

    //getter and setter


    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return this.model + this.name + this.year;
    }
}
