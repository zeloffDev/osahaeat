package com.zeloff.osahaeat.controller;


import com.zeloff.osahaeat.dto.CategoryDto;
import com.zeloff.osahaeat.payload.ResponseData;
import com.zeloff.osahaeat.service.imp.CategoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryImp categoryImp;

    @GetMapping
    public ResponseEntity<?> getCategoryHomepage(@RequestParam(required = false) Integer id , @RequestParam int page, @RequestParam int pageSize) {
        ResponseData responseData = new ResponseData();
        List<CategoryDto> data;
        if (id == null) {
            data = categoryImp.getCategoryHomePage(page, pageSize);
        } else {
            data = categoryImp.getCategoryHomePageById(id, page, pageSize);
        }
        responseData.setData(data);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    ;
}
