package com.zeloff.osahaeat.entity.Keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyMenuRestourant implements Serializable {
    @Column(name = "category_id", insertable = false, updatable = false)
    private int categoryId;

    @Column(name = "restourant_id", insertable = false, updatable = false)
    private int restourantId;

    public KeyMenuRestourant() {
    }

    public KeyMenuRestourant(int categoryId, int restourantId) {
        this.restourantId = restourantId;
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getRestourantId() {
        return restourantId;
    }

    public void setRestourantId(int restourantId) {
        this.restourantId = restourantId;
    }
}
