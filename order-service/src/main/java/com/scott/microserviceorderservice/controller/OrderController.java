package com.scott.microserviceorderservice.controller;

import com.scott.microserviceorderservice.dto.OrderRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@Log4j2
public class OrderController {

    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        log.info("Placing Order");
        return "Order placed successfully";
    }


}
