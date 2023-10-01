package com.zeloff.osahaeat.entity;

import com.zeloff.osahaeat.entity.Keys.KeyMenuRestourant;
import com.zeloff.osahaeat.entity.Keys.KeyOrderDetail;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "order_detail")
public class OrderDetail {
    @EmbeddedId
    private KeyOrderDetail keyOrderDetail;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "price")
    private double price;

    @Column(name = "create_date")
    private Date createDate;

    public KeyOrderDetail getKeyOrderDetail() {
        return keyOrderDetail;
    }

    public void setKeyOrderDetail(KeyOrderDetail keyOrderDetail) {
        this.keyOrderDetail = keyOrderDetail;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
