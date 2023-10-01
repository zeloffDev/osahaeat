package com.zeloff.osahaeat.entity.Keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable

public class KeyOrderDetail implements Serializable {
    @Column(name = "order_id", insertable = false, updatable = false)
    private int orderId;

    @Column(name = "food_id", insertable = false, updatable = false)
    private int foodId;

    public KeyOrderDetail(){}
    public KeyOrderDetail(int orderId, int foodId) {
        this.orderId = orderId;
        this.foodId = foodId;
    }
}
