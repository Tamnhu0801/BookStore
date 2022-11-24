package com.hcmute.bookstore.services;

import com.hcmute.bookstore.dtos.order.OrderDetailReqDto;
import com.hcmute.bookstore.dtos.order.OrderDetailResDto;

public interface OrderDetailService {
    OrderDetailResDto getOrderDetail(Long id);

    OrderDetailResDto addOrderDetail(OrderDetailReqDto orderDetailReqDto);
}
