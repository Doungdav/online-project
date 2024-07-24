package com.path.online_store.services;

import com.path.online_store.models.dto.category.CategoryDto;

import java.util.List;

public interface CategoryService {
    /**
     * This method is used to create a new category
     * resource into database
     * @param categoryDto is the request data from client
     */
    void createNew(CategoryDto categoryDto);

    /**
     * This method is used to retrieve resource category from database
     * @return List<CategoryDto>
     */
    List<CategoryDto> findAll();

    /**
     * This method is used to retrieve resource category by name
     * from database
     * @param name of category
     * @return CategoryDto
     */
    CategoryDto findByName(String name);

}
