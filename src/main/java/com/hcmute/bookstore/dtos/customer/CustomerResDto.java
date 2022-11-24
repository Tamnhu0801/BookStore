package com.hcmute.bookstore.dtos.customer;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResDto {
    private Long id;
    private String username;
    private String fullname;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private boolean enabled;
}
