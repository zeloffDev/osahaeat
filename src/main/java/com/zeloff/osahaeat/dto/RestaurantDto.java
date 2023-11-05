package com.zeloff.osahaeat.dto;

import java.util.Set;

public class RestaurantDto {
    private int id;
    private String image;
    private String title;
    private double rating;
    private String subTitle;
    private boolean isFree;
    private Set<RatingRestaurantDto> ListRatingRestaurantDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<RatingRestaurantDto> getListRatingRestaurantDto() {
        return ListRatingRestaurantDto;
    }

    public void setListRatingRestaurantDto(Set<RatingRestaurantDto> listRatingRestaurantDto) {
        ListRatingRestaurantDto = listRatingRestaurantDto;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
