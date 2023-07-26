package com.zaga.OrderProj;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
        private static final Logger logger = LogManager.getLogger(OrderController.class);

        @Autowired
        OrderService orderService;

        @PostMapping("/createOrders")
        public OrderEntity createOrders(@RequestBody OrderEntity orderEntity) {
                logger.info("Received request to create order: {}", orderEntity);
                OrderEntity details = orderService.createOrderDetails(orderEntity);
                logger.info("Order created successfully: {}", details);
                return details;
        }

        @GetMapping("/getOrders")
        public ResponseEntity<OrderEntity> getOrdersByid(Long id) {
                logger.info("Received request to get order by ID: {}", id);
                OrderEntity getDetails = orderService.getOrderDetails(id);
                if (getDetails != null) {
                        logger.info("Found order with ID {}: {}", id, getDetails);
                        return ResponseEntity.ok(getDetails);
                } else {
                        logger.warn("No order found with ID: {}", id);
                        return ResponseEntity.notFound().build();
                }
        }

}
