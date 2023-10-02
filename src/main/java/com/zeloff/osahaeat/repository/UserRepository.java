package com.zeloff.osahaeat.repository;

import com.zeloff.osahaeat.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> findByUserNameAndPassword(String UserName,String Password);

}
