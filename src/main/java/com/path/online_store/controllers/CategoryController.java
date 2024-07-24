package com.path.online_store.controllers;

import com.path.online_store.models.dao.entities.Category;
import com.path.online_store.models.dto.category.CategoryDto;
import com.path.online_store.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNew(@RequestBody @Valid CategoryDto categoryDto){
        categoryService.createNew(categoryDto);
    }

    @GetMapping("/{cateName}")
    CategoryDto findByName(@PathVariable String cateName){
        return categoryService.findByName(cateName);
    }

    @GetMapping
    List<CategoryDto> findAll(){
       return categoryService.findAll();
    }

}
