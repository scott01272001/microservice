package com.scott.microserviceorderservice.service;

import com.scott.microserviceorderservice.dto.OrderLineItemsDto;
import com.scott.microserviceorderservice.dto.OrderRequest;
import com.scott.microserviceorderservice.model.Order;
import com.scott.microserviceorderservice.model.OrderLineItem;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();

        List<OrderLineItem> orderLineItems = orderRequest.getOrderLineItemsDtoList()
            .stream()
            .map(this::mapToDto)
            .toList();
        order.setOrderLineItems(orderLineItems);

    }

    private OrderLineItem mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItem orderLineItems = new OrderLineItem();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }

}
