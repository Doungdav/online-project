package com.path.online_store.models.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateProductDto {
    @NotBlank(message = "Name is required!")
    @Size(min = 5, max = 255)
    String name;
    @NotBlank(message = "Description is required!")
    @Size(min = 5, message = "Description must be greater than 5")
    String description;
   // @NotBlank
   // String image;
    /*@NotNull(message = "Category ID is required!")
    @Positive(message = "Category ID must be greater than 0")
    Integer categoryId;*/
}