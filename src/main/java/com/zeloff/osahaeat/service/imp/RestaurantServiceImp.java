package com.zeloff.osahaeat.service.imp;

import com.zeloff.osahaeat.dto.RestaurantDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

public interface RestaurantServiceImp {
    boolean insertRestaurant(@RequestParam("file") MultipartFile file,
                             @RequestParam String title,
                             @RequestParam String sub_title,
                             @RequestParam String description,
                             @RequestParam int is_free,
                             @RequestParam String address,
                             @RequestParam String open_date) throws ParseException;

    List<RestaurantDto> getListRestaurant(int page,int pageSize );
}
