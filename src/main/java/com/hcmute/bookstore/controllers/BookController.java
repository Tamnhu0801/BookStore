package com.hcmute.bookstore.controllers;

import com.hcmute.bookstore.dtos.book.BookReqDto;
import com.hcmute.bookstore.entities.ResponseObject;
import com.hcmute.bookstore.services.BookService;
import com.hcmute.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/books")
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(bookService.getAll()).build());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> getBook(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(bookService.getBook(id)).build());
    }

    @PostMapping(value = "")
    public ResponseEntity<ResponseObject> addBook(@RequestBody BookReqDto bookReqDto) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(bookService.addBook(bookReqDto)).build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> updateProduct(@PathVariable(name = "id") Long id,
                                                        @RequestBody BookReqDto bookReqDto) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(bookService.updateBook(id, bookReqDto)).build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> deleteProduct(@PathVariable(name = "id") Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS).build());
    }
}
