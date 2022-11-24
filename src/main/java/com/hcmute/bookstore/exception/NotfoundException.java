package com.hcmute.bookstore.exception;

public class NotfoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

   public NotfoundException() {
       super();
   }

   public NotfoundException(String message) {
       super(message);
   }

   public NotfoundException(String resourceName, String fieldName, Object fieldValue){
       super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
       this.resourceName = resourceName;
       this.fieldName = fieldName;
       this.fieldValue = fieldValue;
   }
}
