package com.path.online_store.services.interfaces;

import com.path.online_store.models.dao.entities.Category;
import com.path.online_store.models.dao.repositories.CategoryRepository;
import com.path.online_store.models.dto.category.CategoryDto;
import com.path.online_store.models.mappers.CategoryMapper;
import com.path.online_store.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void createNew(CategoryDto categoryDto) {
        Category category = categoryMapper.fromCategoryDto(categoryDto);
        categoryRepository.save(category);

    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toCategoryDtoList(categories);
    }

    @Override
    public CategoryDto findByName(String name) {
        Category category = categoryRepository.findByName(name)
                .orElseThrow();
        return categoryMapper.toCategoryDto(category);
    }
}
