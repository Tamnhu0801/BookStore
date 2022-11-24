package com.hcmute.bookstore.controllers;

import com.hcmute.bookstore.entities.ResponseObject;
import com.hcmute.bookstore.services.OrderService;
import com.hcmute.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(orderService.getAllOrders()).build());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> getOrder(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(orderService.getOrder(id)).build());
    }
}
