package com.ecommerce.product.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public record ProductRequest(
    Integer id,

    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    String name,

    @NotNull(message = "Description cannot be null")
    @Size(min = 1, max = 500, message = "Description must be between 1 and 500 characters")
    String description,

    @PositiveOrZero(message = "Available quantity must be zero or positive")
    double availableQuantity,

    @Positive(message = "Price must be positive")
    @NotNull(message = "Price cannot be null")
    BigDecimal price,

    @NotNull(message = "Product category is required")
    Integer categoryId
    ) {
}
