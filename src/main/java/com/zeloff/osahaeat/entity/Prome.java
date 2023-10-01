package com.zeloff.osahaeat.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "prome")
public class Prome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "restourant_id")
    private Restourant restourant;

    @Column(name = "start_date")
    private Date startDate;


    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "percen")
    private int percen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Restourant getRestourant() {
        return restourant;
    }

    public void setRestourant(Restourant restourant) {
        this.restourant = restourant;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPercen() {
        return percen;
    }

    public void setPercen(int percen) {
        this.percen = percen;
    }
}
