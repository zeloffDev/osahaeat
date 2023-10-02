package com.zeloff.osahaeat.service.imp;

import com.zeloff.osahaeat.dto.UsersDto;
import com.zeloff.osahaeat.payload.requestPayload.SignupPayload;

import java.util.List;

public interface LoginServiceImp {
    List<UsersDto> getAllListUser();
    boolean checkLogin(String UserName, String Password);
    boolean checkSignup(SignupPayload signupPayload);
}
