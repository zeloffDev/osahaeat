package com.zeloff.osahaeat.service;


import com.zeloff.osahaeat.dto.CategoryDto;
import com.zeloff.osahaeat.dto.FoodDto;
import com.zeloff.osahaeat.entity.Category;
import com.zeloff.osahaeat.entity.Food;
import com.zeloff.osahaeat.repository.CategoryRepository;
import com.zeloff.osahaeat.service.imp.CategoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService implements CategoryImp {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getCategoryHomePageById(int id, int page, int pageSize) {
        List<CategoryDto> listCategoryDto = new ArrayList<>();
        try {
            PageRequest pageRequest = PageRequest.of(page, pageSize);
            Page<Category> listCategory = categoryRepository.findAllById(id, pageRequest);
            getListFood(listCategoryDto, listCategory);
        } catch (Exception err) {

        }
        return listCategoryDto;
    }
    @Override
    public List<CategoryDto> getCategoryHomePage(int page, int pageSize) {
        List<CategoryDto> listCategoryDto = new ArrayList<>();
        try {
            PageRequest pageRequest = PageRequest.of(page, pageSize);
            Page<Category> listCategory = categoryRepository.findAll(pageRequest);

            getListFood(listCategoryDto, listCategory);
        } catch (Exception err) {

        }
        return listCategoryDto;
    }
    private void getListFood(List<CategoryDto> listCategoryDto, Page<Category> listCategory) {
        for (Category data : listCategory) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(data.getCategoryName());
            List<FoodDto> ListFoodDto = new ArrayList<>();
            Set<Food> listFood = data.getListFood();
            for (Food food : listFood) {
                FoodDto foodDto = new FoodDto();
                foodDto.setTimeShip(food.getTimeShip());
                foodDto.setPrice(food.getPrice());
                foodDto.setImage(food.getImage());
                foodDto.setId(food.getId());
                foodDto.setFreeShip(food.isFreeShip());
                foodDto.setTitle(food.getTitle());
                ListFoodDto.add(foodDto);
            }
            categoryDto.setFoodDto(ListFoodDto);
            listCategoryDto.add(categoryDto);
        }
    }
}
