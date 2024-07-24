package com.path.online_store.models.mappers;

import com.path.online_store.models.dao.entities.Category;
import com.path.online_store.models.dto.category.CategoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category fromCategoryDto(CategoryDto categoryDto);
    CategoryDto toCategoryDto(Category category);
    List<CategoryDto> toCategoryDtoList(List<Category> categories);

}
