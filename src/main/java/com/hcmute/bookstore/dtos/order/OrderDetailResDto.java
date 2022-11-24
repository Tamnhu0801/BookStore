package com.hcmute.bookstore.dtos.order;

import com.hcmute.bookstore.dtos.book.BookResDto;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailResDto {
    private Long orderId;
    private BigDecimal price;
    private Integer quantity;
    private BookResDto book;
}
