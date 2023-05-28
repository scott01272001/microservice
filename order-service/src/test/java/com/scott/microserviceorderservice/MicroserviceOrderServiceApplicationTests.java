package com.scott.microserviceorderservice;

import com.scott.microserviceorderservice.model.Order;
import com.scott.microserviceorderservice.model.OrderLineItem;
import com.scott.microserviceorderservice.repository.OrderRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class MicroserviceOrderServiceApplicationTests {

	@Autowired
	private OrderRepository orderRepository;

	@Container
	public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(
		"postgres:15.3-alpine")
		.withUsername("product_service")
		.withPassword("password");

	@DynamicPropertySource
	public static void setProperty(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
	}

	@Test
	void contextLoads() {
		OrderLineItem orderLineItem1 = OrderLineItem.builder().price(BigDecimal.valueOf(1)).skuCode("1").quantity(1).build();
		OrderLineItem orderLineItem2 = OrderLineItem.builder().price(BigDecimal.valueOf(2)).skuCode("2").quantity(1).build();

		List<OrderLineItem> orderLineItemList = new ArrayList<>();
		orderLineItemList.add(orderLineItem1);
		orderLineItemList.add(orderLineItem2);

		Order order = Order.builder().orderNumber(UUID.randomUUID().toString()).orderLineItems(orderLineItemList).build();

		orderRepository.save(order);

	}

}
