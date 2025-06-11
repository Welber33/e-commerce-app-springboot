package com.ecommerce.product.product;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    Object findAllByIdInOrderById(List<Integer> productIds);
}
