package com.zeloff.osahaeat.service;

import com.zeloff.osahaeat.entity.Category;
import com.zeloff.osahaeat.entity.Food;
import com.zeloff.osahaeat.repository.FoodRepository;
import com.zeloff.osahaeat.service.imp.FilesStorageServiceImp;
import com.zeloff.osahaeat.service.imp.FoodImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FoodService implements FoodImp {
    @Autowired
    FilesStorageServiceImp filesStorageServiceImp;
    @Autowired
    FoodRepository foodRepository;
    @Override
    public boolean createFood(MultipartFile image, String title, String time_ship, double price, int is_free_ship, int category_id) {
        boolean isSuccess = false;
        try {
            boolean isSuccessSaveFile = filesStorageServiceImp.save(image);
            boolean isFree = is_free_ship == 1;
            if (isSuccessSaveFile) {
                Food food = new Food();
                food.setTitle(title);
                food.setImage(image.getOriginalFilename());
                Category category = new Category();
                category.setId(category_id);
                food.setCategory(category);
                food.setFreeShip(isFree);
                food.setPrice(price);
                food.setTimeShip(time_ship);
                foodRepository.save(food);
                isSuccess = true;
            }
        } catch (Exception e) {

        }

        return isSuccess;
    }
}
