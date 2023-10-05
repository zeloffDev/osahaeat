package com.zeloff.osahaeat.controller;


import com.zeloff.osahaeat.service.imp.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestResController {
    @GetMapping
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("Test CC", HttpStatus.OK);
    }
}
