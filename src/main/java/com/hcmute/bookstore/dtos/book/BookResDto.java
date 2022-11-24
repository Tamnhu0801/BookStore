package com.hcmute.bookstore.dtos.book;

import com.hcmute.bookstore.dtos.author.AuthorResDto;
import com.hcmute.bookstore.dtos.category.CategoryResDto;
import com.hcmute.bookstore.dtos.company.CompanyResDto;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResDto {
    private Long id;
    private String name;
    private String description;
    private Date publishDate;
    private BigDecimal price;
    private BigDecimal coverPrice;
    private CategoryResDto category;
    private AuthorResDto author;
    private CompanyResDto company;
    private String publishingHouse;
    private String translator;
    private long numberOfPages;
    private int quantity;
    private boolean status;

    private Date createTime;
    private Date updateTime;
}
