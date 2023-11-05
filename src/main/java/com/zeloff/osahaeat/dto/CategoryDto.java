package com.zeloff.osahaeat.dto;

import java.util.List;

public class CategoryDto {
    private String Name;
    private List<FoodDto> foodDto;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<FoodDto> getFoodDto() {
        return foodDto;
    }

    public void setFoodDto(List<FoodDto> foodDto) {
        this.foodDto = foodDto;
    }
}
