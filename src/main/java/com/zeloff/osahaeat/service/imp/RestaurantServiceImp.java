package com.zeloff.osahaeat.service.imp;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;

public interface RestaurantServiceImp {
    boolean insertRestaurant(@RequestParam("file") MultipartFile file,
                             @RequestParam String title,
                             @RequestParam String sub_title,
                             @RequestParam String description,
                             @RequestParam boolean is_free,
                             @RequestParam String address,
                             @RequestParam String open_date) throws ParseException;
}
