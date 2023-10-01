package com.zeloff.osahaeat.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne()
    @JoinColumn(name = "restourant_id")
    private Restourant restourant;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetail> listOrderDetails;

    public Set<OrderDetail> getListOrderDetails() {
        return listOrderDetails;
    }

    public void setListOrderDetails(Set<OrderDetail> listOrderDetails) {
        this.listOrderDetails = listOrderDetails;
    }

    @Column(name = "create_date")
    private Date createDate;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
