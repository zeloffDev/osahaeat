package com.zeloff.osahaeat.repository;

import com.zeloff.osahaeat.entity.Restourant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restourant, Integer> {
}
