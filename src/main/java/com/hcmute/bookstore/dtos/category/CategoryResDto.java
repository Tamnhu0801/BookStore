package com.hcmute.bookstore.dtos.category;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResDto {
    private Long id;
    private String name;
    private CategoryResDto parent;
    private String allParentNames;

    @JsonFormat(pattern="dd-MM-yyy HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern="dd-MM-yyy HH:mm:ss")
    private Date updateTime;
}
