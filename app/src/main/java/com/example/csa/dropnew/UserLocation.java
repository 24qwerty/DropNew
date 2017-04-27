package com.example.csa.dropnew;

import java.io.Serializable;

/**
 * Created by Hrishi on 27-04-2017.
 */
public class UserLocation implements Serializable {
    private String name="";
    private String email="";
    private String contact_number="";
    private int uid=0;
    private double latitude=0;
    private double longitude=0;
    private Boolean public_visibilty=false;
    private String description="";
    private String category="";
    private int password=0;
    public UserLocation(){
    }

    public UserLocation(String name,String email,String contact_number,int uid, Boolean public_visibilty,double latitude,double longitude,String category,String description){
        this.latitude=latitude;
        this.name=name;
        this.contact_number=contact_number;
        this.email=email;
        this.description=description;
        this.longitude=longitude;
        this.category=category;
        this.uid=uid;
        this.public_visibilty=public_visibilty;
    }

    public String getDescription() {
        return description;
    }

    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Boolean getPublic_visibilty() {
        return public_visibilty;
    }

    public void setPublic_visibilty(Boolean public_visibilty) {
        this.public_visibilty = public_visibilty;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
