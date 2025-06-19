package com.ecommerce.product.product;

import java.util.ArrayList;
<<<<<<< HEAD

import com.ecommerce.product.product.ProductMapper;
import com.ecommerce.product.product.ProductRepository;
import com.ecommerce.product.product.ProductRequest;
import com.ecommerce.product.product.ProductPurchaseRequest;
import com.ecommerce.product.product.ProductPurchaseResponse;
import com.ecommerce.product.product.ProductResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.ecommerce.product.exception.ProductPurchaseException;

import jakarta.persistence.EntityNotFoundException;
=======
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.product.exception.ProductPurchaseException;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
>>>>>>> c578cec7149d0b70e27147b91bac50a04f5daff7

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public Integer createProduct(ProductRequest request) {
        var product = mapper.toProduct(request);
        return repository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        var productIds = request.stream()
                .map(ProductPurchaseRequest::productId)
                .toList();

        var storedProducts = repository.findAllByIdInOrderById(productIds);

        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exists");
        }

        var storedRequest = request.stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();

        List<ProductPurchaseResponse> purchasedProducts = new ArrayList<>();

        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storedRequest.get(i);

            if (product.getAvailableQuantity() < productRequest.quantity()) {
<<<<<<< HEAD
                throw new ProductPurchaseException("Product with ID: " + productRequest.productId() + " does not have enough quantity");
=======
                throw new ProductPurchaseException(
                        "Product with ID: " + productRequest.productId() + " does not have enough quantity");
>>>>>>> c578cec7149d0b70e27147b91bac50a04f5daff7
            }

            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();

            product.setAvailableQuantity(newAvailableQuantity);
            repository.save(product);

            purchasedProducts.add(mapper.toProductPurchaseResponse(
                    product,
                    productRequest.quantity()));
        }

        return purchasedProducts;
    }

    public ProductResponse findById(Integer productId) {

        return repository.findById(productId)
                .map(mapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product with ID: " + productId + " was not found"));
    }

    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
