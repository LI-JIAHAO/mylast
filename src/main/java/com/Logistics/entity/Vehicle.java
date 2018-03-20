package com.Logistics.entity;

import java.io.Serializable;

public class Vehicle implements Serializable {
    private Integer id;
    private String location;
    private  String des;
    private String disable;

    public Vehicle(){

    }

    public Vehicle(Integer id, String location, String des, String disable){
        this.id=id;
        this.location=location;
        this.des=des;
        this.disable=disable;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", des='" + des + '\'' +
                ", disable='" + disable + '\'' +
                '}';
    }
}
