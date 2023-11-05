package com.zeloff.osahaeat.dto;

import com.zeloff.osahaeat.entity.Users;

public class RatingRestaurantDto {
    private int id ;
    private String content;
    private int ratePoin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
