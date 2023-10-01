package com.zeloff.osahaeat.service;

import com.zeloff.osahaeat.dto.UsersDto;
import com.zeloff.osahaeat.entity.Users;
import com.zeloff.osahaeat.repository.UserRepository;
import com.zeloff.osahaeat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UsersDto> getAllListUser(){
        List<Users> listUsers = userRepository.findAll();
        List<UsersDto> listUsersDto = new ArrayList<>();

        for (Users users : listUsers) {
            UsersDto usersDto = new UsersDto();
            usersDto.setFullName(users.getFullName());
            usersDto.setUserName(users.getUserName());
            usersDto.setId(users.getId());
            usersDto.setPassword(users.getPassword());
            usersDto.setCreateDate(users.getCreateDate());

            listUsersDto.add(usersDto);
        }
        return listUsersDto;
    }

    @Override
    public boolean checkLogin(String UserName, String Password) {
        List<Users> listUsers = userRepository.findByUserNameAndPassword(UserName,Password);
        System.out.println(UserName);
        System.out.println(Password);
        for(Users users: listUsers){
            System.out.println(users.getUserName());
        }
        return !listUsers.isEmpty();
    }
}
