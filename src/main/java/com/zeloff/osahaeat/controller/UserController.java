package com.zeloff.osahaeat.controller;

import com.zeloff.osahaeat.dto.UsersDto;
import com.zeloff.osahaeat.payload.ResponseData;
import com.zeloff.osahaeat.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("/getAllUser")
    public ResponseEntity<?> test() {
        ResponseData responseData = new ResponseData();
        List<UsersDto> listUserDto = userServiceImp.getAllUser();
        responseData.setData(listUserDto);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
