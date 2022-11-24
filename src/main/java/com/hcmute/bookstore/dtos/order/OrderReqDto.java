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
public class OrderReqDto {
    private Long id;
    private String receiverName;
    private String phone;
    private String address;
    private BigDecimal shippingFee;
    private BigDecimal total;
    private String paymentMethod;
    private Boolean paymentStatus;
    private Long customerId;
}
