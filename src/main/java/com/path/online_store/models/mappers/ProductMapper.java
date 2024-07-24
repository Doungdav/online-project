package com.path.online_store.models.mappers;

import com.path.online_store.models.dao.entities.Product;
import com.path.online_store.models.dto.product.CreateProductDto;
import com.path.online_store.models.dto.product.ProductDto;
import com.path.online_store.models.dto.product.UpdateProductDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product fromCreateProductDto(CreateProductDto createProductDto);
    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateProductDto(@MappingTarget Product product, UpdateProductDto updateProductDto);
    ProductDto toProductDto(Product product);
    List<ProductDto> toProductDtoList(List<Product> products);
}
