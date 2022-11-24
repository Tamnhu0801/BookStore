package com.hcmute.bookstore.services.impl;

import com.hcmute.bookstore.dtos.order.OrderResDto;
import com.hcmute.bookstore.exception.NotfoundException;
import com.hcmute.bookstore.mapstruct.OrderMapper;
import com.hcmute.bookstore.repositories.OrderRepository;
import com.hcmute.bookstore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public long getQuantityOrder() {
        return orderRepo.count();
    }

    @Override
    public List<OrderResDto> getAllOrders() {
        return null;
    }

    @Override
    public OrderResDto getOrder(Long id) {
        return OrderMapper.INSTANCE.orderToDto(orderRepo.findById(id)
                .orElseThrow(() -> new NotfoundException("order", "id", id)));
    }

    @Override
    public BigDecimal getTotalRevenue() {
        return orderRepo.findTotalRevenue();
    }
}
