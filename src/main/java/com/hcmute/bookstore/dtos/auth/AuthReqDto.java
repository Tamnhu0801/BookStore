package com.hcmute.bookstore.dtos.auth;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class AuthReqDto {
    @Size(message="Invalid email size.", max = 320, min = 10)
    @NotNull(message="An email is required!")
    @Pattern(regexp=("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"), message = "Invalid email")
    private String email;

    @Length(message="Invalid password size.", min = 6, max = 16)
    @NotNull( message="An password is required!")
    private String password;
}
