package com.zeloff.osahaeat.repository;

import com.zeloff.osahaeat.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllById(int id);
    Page<Category> findAllById(int id, PageRequest pageRequest);
}
