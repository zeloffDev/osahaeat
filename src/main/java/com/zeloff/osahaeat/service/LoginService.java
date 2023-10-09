package com.zeloff.osahaeat.service;

import com.zeloff.osahaeat.dto.UsersDto;
import com.zeloff.osahaeat.entity.Roles;
import com.zeloff.osahaeat.entity.Users;
import com.zeloff.osahaeat.payload.requestPayload.SignupPayload;
import com.zeloff.osahaeat.repository.UserRepository;
import com.zeloff.osahaeat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UsersDto> getAllListUser() {
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
        List<Users> listUsers = userRepository.findByUserNameAndPassword(UserName, Password);
        for (Users users : listUsers) {
            System.out.println(users.getUserName());
        }
        return !listUsers.isEmpty();
    }

    @Override
    public boolean checkSignup(SignupPayload signupPayload) {
        Users users = new Users();
        Roles roles = new Roles();
        roles.setId(signupPayload.getRoleId());
        users.setFullName(signupPayload.getFullName());
        users.setPassword(signupPayload.getPassword());
        users.setEmail(signupPayload.getEmail());
        users.setRoles(roles);
        try {
            userRepository.save(users);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
