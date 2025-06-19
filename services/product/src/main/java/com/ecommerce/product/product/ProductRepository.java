package com.ecommerce.product.product;

import java.util.List;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{
=======
public interface ProductRepository extends JpaRepository<Product, Integer> {
>>>>>>> c578cec7149d0b70e27147b91bac50a04f5daff7

    List<Product> findAllByIdInOrderById(List<Integer> productIds);
}
