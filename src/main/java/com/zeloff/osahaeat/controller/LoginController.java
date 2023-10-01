package com.zeloff.osahaeat.controller;

import com.zeloff.osahaeat.payload.Payload;
import com.zeloff.osahaeat.service.LoginService;
import com.zeloff.osahaeat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String userName, @RequestParam String password) {
        Payload payload = new Payload();
        if (loginServiceImp.checkLogin(userName, password)) {
            payload.setData(true);
        } else {
            payload.setData(false);
        }

        return new ResponseEntity<>(payload, HttpStatus.OK);
    }
}
