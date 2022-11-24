package com.hcmute.bookstore.services;

import com.hcmute.bookstore.dtos.order.OrderResDto;
import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    long getQuantityOrder();

    List<OrderResDto> getAllOrders();

    OrderResDto getOrder(Long id);

    BigDecimal getTotalRevenue();
}
