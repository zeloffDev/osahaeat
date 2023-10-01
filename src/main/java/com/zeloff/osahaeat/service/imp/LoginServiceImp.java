package com.zeloff.osahaeat.service.imp;

import com.zeloff.osahaeat.dto.UsersDto;

import java.util.List;

public interface LoginServiceImp {
    List<UsersDto> getAllListUser();
    boolean checkLogin(String UserName, String Password);
}
