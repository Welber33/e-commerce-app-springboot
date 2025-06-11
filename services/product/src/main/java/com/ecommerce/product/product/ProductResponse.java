package com.ecommerce.product.product;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        Double price,
        Integer availableQuantity,
        Integer categoryId,
        String categoryName,
        String categoryDescription
) {

}
