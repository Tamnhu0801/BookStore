package com.hcmute.bookstore.dtos.auth;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResDto {
    private String email;
    private String accessToken;
}
