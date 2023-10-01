package com.zeloff.osahaeat.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;

    @Column(name = "image")
    private String image;

    @Column(name = "time_ship")
    private String timeShip;
    @Column(name = "price")
    private double price;

    @Column(name = "is_free_ship ")
    private boolean isFreeShip;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "food")
    private Set<RatingFood> listRatingFoods;

    @OneToMany(mappedBy = "food")
    private Set<OrderDetail> listOrderDetails;

    public Set<OrderDetail> getListOrderDetails() {
        return listOrderDetails;
    }

    public void setListOrderDetails(Set<OrderDetail> listOrderDetails) {
        this.listOrderDetails = listOrderDetails;
    }

    public Set<RatingFood> getListRatingFoods() {
        return listRatingFoods;
    }

    public void setListRatingFoods(Set<RatingFood> listRatingFoods) {
        this.listRatingFoods = listRatingFoods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimeShip() {
        return timeShip;
    }

    public void setTimeShip(String timeShip) {
        this.timeShip = timeShip;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isFreeShip() {
        return isFreeShip;
    }

    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
