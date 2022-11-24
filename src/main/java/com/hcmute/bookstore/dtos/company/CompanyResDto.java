package com.hcmute.bookstore.dtos.company;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyResDto {
    private Long id;
    private String name;
    private String info;
}
