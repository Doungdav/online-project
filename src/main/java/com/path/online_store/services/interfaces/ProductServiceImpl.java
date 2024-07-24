package com.path.online_store.services.interfaces;

import com.path.online_store.models.dao.entities.Product;
import com.path.online_store.models.dao.repositories.ProductRepository;
import com.path.online_store.models.dto.product.CreateProductDto;
import com.path.online_store.models.dto.product.ProductDto;
import com.path.online_store.models.dto.product.UpdateProductDto;
import com.path.online_store.models.mappers.ProductMapper;
import com.path.online_store.services.ProductService;
import com.path.online_store.until.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public void createNew(CreateProductDto createProductDto) {
        Product product = productMapper.fromCreateProductDto(createProductDto);
        product.setUuid(UUID.randomUUID().toString());
        product.setCode("PRO-" + RandomUtil.generateCode());
        productRepository.save(product);

    }

    @Override
    public void updateByUuid(String uuid, UpdateProductDto updateProductDto) {
        // Step 1: Check uuid of product in the database
        if (productRepository.existsByUuid(uuid)) {

            // Step 2: Load old product
            Product product = productRepository.findByUuid(uuid)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            String.format("Product UUID = %s doesn't exist in db!", uuid)));

            // Step 3: Map updating product partially
            productMapper.fromUpdateProductDto(product, updateProductDto);

            /*if (updateProductDto.categoryId() != null) {
                Category newCategory = new Category();
                newCategory.setId(updateProductDto.categoryId());
                product.setCategory(newCategory);
            }*/

            // Step 4: Save latest product
            productRepository.save(product);

            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Product UUID = %s doesn't exist in db!", uuid));

    }

    @Override
    public void deleteByUuid(String uuid) {
        Product product = productRepository.findByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Product UUID = %s doesn't exist in db!", uuid))
        );
        productRepository.delete(product);

    }

    @Override
    public ProductDto findByUuid(String uuid) {
        Product product = productRepository.findByUuid(uuid).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Product UUID = %s doesn't exist in db!", uuid)));
        return productMapper.toProductDto(product);
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.toProductDtoList(products);
    }
}
