package com.hcmute.bookstore.dtos.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hcmute.bookstore.dtos.customer.CustomerResDto;
import com.hcmute.bookstore.util.Constant;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResDto {
    private Long id;
    private int orderStatus;
    private String receiverName;
    private String phone;
    private String address;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = Constant.MY_TIME_ZONE)
    private Date orderTime;

    private BigDecimal shippingFee;
    private BigDecimal total;
    private String paymentMethod;
    private Boolean paymentStatus;
    private List<OrderDetailResDto> orderDetails;
    private CustomerResDto customer;
}
