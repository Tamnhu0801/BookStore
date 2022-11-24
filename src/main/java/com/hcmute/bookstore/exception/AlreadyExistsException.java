package com.hcmute.bookstore.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlreadyExistsException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public AlreadyExistsException() {
        super();
    }

    public AlreadyExistsException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s is existed with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
