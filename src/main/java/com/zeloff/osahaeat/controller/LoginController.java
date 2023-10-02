package com.zeloff.osahaeat.controller;

import com.zeloff.osahaeat.payload.ResponseData;
import com.zeloff.osahaeat.payload.requestPayload.SignupPayload;
import com.zeloff.osahaeat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String userName, @RequestParam String password) {
        ResponseData responseData = new ResponseData();
        if (loginServiceImp.checkLogin(userName, password)) {
            responseData.setData(true);
        } else {
            responseData.setData(false);
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupPayload signupPayload) {
        ResponseData responseData = new ResponseData();
        responseData.setData(loginServiceImp.checkSignup(signupPayload));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
