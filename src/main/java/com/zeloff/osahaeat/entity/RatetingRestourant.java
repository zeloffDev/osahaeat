package com.zeloff.osahaeat.entity;

import jakarta.persistence.*;

@Entity(name = "rateting_restourant")
public class RatetingRestourant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "restourant_id")
    private Restourant restourant;

    @Column(name = "content")
    private String content;

    @Column(name = "rate_poin")
    private int ratePoin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Restourant getRestourant() {
        return restourant;
    }

    public void setRestourant(Restourant restourant) {
        this.restourant = restourant;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRatePoin() {
        return ratePoin;
    }

    public void setRatePoin(int ratePoin) {
        this.ratePoin = ratePoin;
    }
}
