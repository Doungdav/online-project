package com.path.online_store.models.dto.product;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateProductDto {
    @Size(min = 5, max = 255)
    String name;
    @Size(min = 5, message = "Description must be greater than 5")
    String description;
    /*@Positive(message = "Category ID must be greater than 0")
    Integer categoryId;*/
}
