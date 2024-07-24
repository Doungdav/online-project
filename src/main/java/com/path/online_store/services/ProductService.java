package com.path.online_store.services;

import com.path.online_store.models.dto.product.CreateProductDto;
import com.path.online_store.models.dto.product.ProductDto;
import com.path.online_store.models.dto.product.UpdateProductDto;

import java.util.List;

public interface ProductService {

    void createNew (CreateProductDto createProductDto);
    void updateByUuid(String uuid, UpdateProductDto updateProductDto);
    void deleteByUuid(String uuid);
    ProductDto findByUuid(String uuid);
    List<ProductDto> findAll();
}
