package com.zeloff.osahaeat.controller;

import com.zeloff.osahaeat.payload.ResponseData;
import com.zeloff.osahaeat.payload.requestPayload.SignupPayload;
import com.zeloff.osahaeat.service.imp.LoginServiceImp;
import com.zeloff.osahaeat.util.JwtHelperUntil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtHelperUntil jwtHelperUntil;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String userName, @RequestParam String password) {
        ResponseData responseData = new ResponseData();
        String token = jwtHelperUntil.generateToken(userName);

        if (loginServiceImp.checkLogin(userName, password)) {
            responseData.setData(token);
        } else {
            responseData.setSuccess(false);
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
