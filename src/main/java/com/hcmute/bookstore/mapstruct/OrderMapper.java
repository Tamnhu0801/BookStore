package com.hcmute.bookstore.mapstruct;

import com.hcmute.bookstore.dtos.order.OrderDetailReqDto;
import com.hcmute.bookstore.dtos.order.OrderDetailResDto;
import com.hcmute.bookstore.dtos.order.OrderReqDto;
import com.hcmute.bookstore.dtos.order.OrderResDto;
import com.hcmute.bookstore.entities.Order;
import com.hcmute.bookstore.entities.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    //---------------------OrderDetail---------------------------

    OrderDetailResDto orderDetailToDto(OrderDetail orderDetail);

    List<OrderResDto> orderDetailsToDtos(List<Order> orders);

    OrderDetail dtoToOrderDetail(OrderDetailReqDto orderDetailReqDto);

    List<OrderDetail> dtosToOrderDetails(List<OrderDetailReqDto> orderDetailReqDtos);

    //---------------------Order------------------------------
    OrderResDto orderToDto(Order order);

    List<OrderResDto> ordersToDtos(List<Order> orders);

    @Mapping(source = "customerId", target = "customer.id")
    Order dtoToOrder(OrderReqDto orderReqDto);

    List<Order> dtosToOrders(List<OrderReqDto> orderReqDto);
}
