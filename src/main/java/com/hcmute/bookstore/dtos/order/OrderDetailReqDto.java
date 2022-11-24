package com.hcmute.bookstore.dtos.order;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailReqDto {
    private Long orderId;
    private BigDecimal price;
    private Integer quantity;
    private Long bookId;
}
