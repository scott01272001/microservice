package com.scott.microserviceorderservice.repository;

import com.scott.microserviceorderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
