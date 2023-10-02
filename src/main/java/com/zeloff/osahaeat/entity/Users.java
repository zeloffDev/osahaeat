package com.zeloff.osahaeat.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private Set<RatingFood> listRatingFoods;

    @OneToMany(mappedBy = "users")
    private Set<RatetingRestourant> listRatetingRestourant;

    @OneToMany(mappedBy = "users")
    private Set<Orders> listOrder;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Orders> getListOrder() {
        return listOrder;
    }

    public void setListOrder(Set<Orders> listOrder) {
        this.listOrder = listOrder;
    }

    public Set<RatetingRestourant> getListRatetingRestourant() {
        return listRatetingRestourant;
    }

    public void setListRatetingRestourant(Set<RatetingRestourant> listRatetingRestourant) {
        this.listRatetingRestourant = listRatetingRestourant;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
