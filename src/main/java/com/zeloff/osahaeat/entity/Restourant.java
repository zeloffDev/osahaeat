package com.zeloff.osahaeat.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "restourant")
public class Restourant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "sub_title")
    private String subTitle;
    @Column(name = "description")
    private String description;
    @Column(name = " image")
    private String image;

    @Column(name = "is_free")
    private boolean isFree;

    @Column(name = "address")
    private String address;

    @Column(name = "open_date")
    private Date openDate;

    @OneToMany(mappedBy = "restourant")
    private Set<RatetingRestourant> listRatetingRestourant;

    @OneToMany(mappedBy = "restourant")
    private Set<MenuRestaurant> listRestourants;

    @OneToMany(mappedBy = "restourant")
    private Set<Orders> listOrders;

    @OneToMany(mappedBy = "restourant")
    private Set<Prome> listPromes;

    public Set<Prome> getListPromes() {
        return listPromes;
    }

    public void setListPromes(Set<Prome> listPromes) {
        this.listPromes = listPromes;
    }

    public Set<Orders> getListOrders() {
        return listOrders;
    }

    public void setListOrders(Set<Orders> listOrders) {
        this.listOrders = listOrders;
    }

    public Set<MenuRestaurant> getListRestourants() {
        return listRestourants;
    }

    public void setListRestourants(Set<MenuRestaurant> liRestaurants) {
        this.listRestourants = liRestaurants;
    }

    public Set<RatetingRestourant> getListRatetingRestourant() {
        return listRatetingRestourant;
    }

    public void setListRatetingRestaurant(Set<RatetingRestourant> listRatetingRestaurant) {
        this.listRatetingRestourant = listRatetingRestaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }
}
