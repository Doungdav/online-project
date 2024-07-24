package com.path.online_store.controllers;

import com.path.online_store.models.dto.product.CreateProductDto;
import com.path.online_store.models.dto.product.ProductDto;
import com.path.online_store.models.dto.product.UpdateProductDto;
import com.path.online_store.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{uuid}")
    ProductDto findByUuid(@PathVariable String uuid) {
        return productService.findByUuid(uuid);
    }

    @GetMapping
    List<ProductDto> findAll(){
       return productService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNew (@RequestBody @Valid CreateProductDto createProductDto){
        productService.createNew(createProductDto);
    }

    @PatchMapping("/{uuid}")
    void updateProductDto(@PathVariable String uuid,
                          @RequestBody UpdateProductDto updateProductDto){
        productService.updateByUuid(uuid, updateProductDto);
    }

    @DeleteMapping("/{uuid}")
    void deleteByUuid(@PathVariable String uuid){
        productService.deleteByUuid(uuid);
    }
}
