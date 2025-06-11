package com.ecommerce.product.product;

import org.springframework.stereotype.Service;
import com.ecommerce.product.category.Category;
import com.ecommerce.product.product.ProductRequest;
import com.ecommerce.product.product.Product;

@Service
public class ProductMapper {

    public Object toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .availableQuantity(request.availableQuantity())
                .category(
                    Category.builder()
                    .id(request.categoryId())
                    .build())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAvailableQuantity(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity,
        );
    }
}
