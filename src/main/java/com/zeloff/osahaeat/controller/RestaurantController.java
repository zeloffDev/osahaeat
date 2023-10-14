package com.zeloff.osahaeat.controller;

import com.zeloff.osahaeat.payload.ResponseData;
import com.zeloff.osahaeat.service.imp.FilesStorageServiceImp;
import com.zeloff.osahaeat.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    FilesStorageServiceImp filesStorageServiceImp;
    @Autowired
    RestaurantServiceImp restaurantServiceImp;

    @PostMapping()
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
                                        @RequestParam String title,
                                        @RequestParam String sub_title,
                                        @RequestParam String description,
                                        @RequestParam boolean is_free,
                                        @RequestParam String address,
                                        @RequestParam String open_date) throws ParseException {

        ResponseData responseData = new ResponseData();
        boolean isSuccess = restaurantServiceImp.insertRestaurant(file,
                title,
                sub_title,
                description,
                is_free,
                address,
                open_date);
        responseData.setData(isSuccess);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        Resource file = filesStorageServiceImp.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
