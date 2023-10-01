package com.zeloff.osahaeat.entity;

import com.zeloff.osahaeat.entity.Keys.KeyMenuRestourant;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "menu_restourant")
public class MenuRestourant {
    @EmbeddedId
    private KeyMenuRestourant keyMenuRestourant;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "restourant_id")
    private Restourant restourant;
    @Column(name="create_date")
    private Date crate_date ;

    public KeyMenuRestourant getKeyMenuRestourant() {
        return keyMenuRestourant;
    }

    public void setKeyMenuRestourant(KeyMenuRestourant keyMenuRestourant) {
        this.keyMenuRestourant = keyMenuRestourant;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Restourant getRestourant() {
        return restourant;
    }

    public void setRestourant(Restourant restourant) {
        this.restourant = restourant;
    }

    public Date getCrate_date() {
        return crate_date;
    }

    public void setCrate_date(Date crate_date) {
        this.crate_date = crate_date;
    }
}
