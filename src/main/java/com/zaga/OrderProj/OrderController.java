package com.zaga.OrderProj;

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

        @Autowired
        OrderService orderService;

        @PostMapping("/createOrders")
        public OrderEntity createOrders(@RequestBody OrderEntity orderEntity) {
                OrderEntity details = orderService.createOrderDetails(orderEntity);
                return details;
        }

        @GetMapping("/getOrders")
        public ResponseEntity<OrderEntity> getOrdersByid(Long id) {
                OrderEntity getDetails = orderService.getOrderDetails(id);
                return ResponseEntity.ok(getDetails);
        }

}
