package com.scott.microserviceproductservice.repository;

import com.scott.microserviceproductservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
