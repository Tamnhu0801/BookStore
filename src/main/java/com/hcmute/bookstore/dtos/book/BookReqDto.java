package com.hcmute.bookstore.dtos.book;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookReqDto {
    private Long id;
    private String name;
    private String description;
    private Date publishDate;
    private BigDecimal price;
    private BigDecimal coverPrice;
    private Long categoryId;
    private Long authorId;
    private Long companyId;
    private String publishingHouse;
    private String translator;
    private long numberOfPages;
    private int quantity;
    private boolean status;
}
