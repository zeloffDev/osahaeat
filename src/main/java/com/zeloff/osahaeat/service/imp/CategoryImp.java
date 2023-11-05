package com.zeloff.osahaeat.service.imp;

import com.zeloff.osahaeat.dto.CategoryDto;

import java.util.List;

public interface CategoryImp {
    List<CategoryDto> getCategoryHomePageById(int id, int page, int pageSize);
    List<CategoryDto> getCategoryHomePage(int page, int pageSize);
}
