package com.zeloff.osahaeat.entity;

import jakarta.persistence.*;

@Entity(name="rating_food")
public class RatingFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "rate_poin")
    private int ratePoin;

    @Column(name="content")
    private String content;

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

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getRatePoin() {
        return ratePoin;
    }

    public void setRatePoin(int ratePoin) {
        this.ratePoin = ratePoin;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
