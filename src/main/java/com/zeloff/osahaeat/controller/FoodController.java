package com.zeloff.osahaeat.controller;


import com.zeloff.osahaeat.payload.ResponseData;
import com.zeloff.osahaeat.service.imp.FoodImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin("*")
@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodImp foodImp;

    @PostMapping()
    public ResponseEntity<?> createFood(
            @RequestParam("image") MultipartFile image,
            @RequestParam String title,
            @RequestParam String time_ship,
            @RequestParam double price,
            @RequestParam int is_free_ship,
            @RequestParam int category_id
    ) {

        ResponseData responseData = new ResponseData();
        boolean isSuccess = foodImp.createFood(image, title, time_ship, price, is_free_ship, category_id);
        responseData.setData(isSuccess);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
