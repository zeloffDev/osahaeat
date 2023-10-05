package com.zeloff.osahaeat.security;

import com.zeloff.osahaeat.entity.Users;
import com.zeloff.osahaeat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users = userRepository.findByUserName(userName);
        if (users == null) {
            throw new UsernameNotFoundException("User not found with username or email: " + userName);
        }
        return new org.springframework.security.core.userdetails.User(users.getUserName(),
                users.getPassword(),
                new ArrayList<>());
    }
}
