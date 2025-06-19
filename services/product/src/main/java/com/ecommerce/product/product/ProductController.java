package com.ecommerce.product.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD
import jakarta.validation.Valid;
import java.util.List;
import com.ecommerce.product.product.ProductRequest;
import com.ecommerce.product.product.ProductPurchaseRequest;
import com.ecommerce.product.product.ProductPurchaseResponse;
import com.ecommerce.product.product.ProductResponse;
import com.ecommerce.product.product.ProductService;
import org.springframework.http.HttpStatus;
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
>>>>>>> c578cec7149d0b70e27147b91bac50a04f5daff7

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest request) {
        return ResponseEntity.ok(service.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(@RequestBody @Valid List<ProductPurchaseRequest> request) {
        return ResponseEntity.ok(service.purchaseProducts(request));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") Integer productId) {
        return ResponseEntity.ok(service.findById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
