package com.scott.orderservice;

import com.scott.orderservice.dto.InventoryResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class OrderServiceApplicationTests {

	@Autowired
	private WebClient webClient;

	@Test
	void contextLoads() {
		InventoryResponse[] inventoryResponsesArray = webClient.get()
			.uri("http://localhost:8003/api/inventory",
				uriBuilder -> uriBuilder.queryParam("skuCodes", "iphone_13").build())
			.retrieve()
			.bodyToMono(InventoryResponse[].class)
			.block();

		List<InventoryResponse> r = Arrays.stream(inventoryResponsesArray).collect(Collectors.toList());
		System.out.println(r);
	}

}
