package com.hcmute.bookstore.entities;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseObject {

    private HttpStatus status;
    private String message;
    private Object data;

}
