package com.zeloff.osahaeat.service.imp;
import org.springframework.web.multipart.MultipartFile;
public interface FoodImp {
    public boolean createFood(
            MultipartFile image,
            String title,
            String time_ship,
            double price,
            int is_free_ship,
            int category_id
    );
}
