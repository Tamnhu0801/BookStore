package com.hcmute.bookstore.controllers;

import com.hcmute.bookstore.dtos.author.AuthorReqDto;
import com.hcmute.bookstore.entities.ResponseObject;
import com.hcmute.bookstore.services.AuthorService;
import com.hcmute.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "*")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(authorService.getAll()).build());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> getAuthor(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(authorService.getAuthor(id)).build());
    }

    @PostMapping
    public ResponseEntity<ResponseObject> addAuthor(@RequestBody AuthorReqDto authorReqDto) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(authorService.addAuthor(authorReqDto)).build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> updateAuthor(@PathVariable(name = "id") Long id,
                                                        @RequestBody AuthorReqDto authorReqDto) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(authorService.updateAuthor(id, authorReqDto)).build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> deleteAuthor(@PathVariable(name = "id") Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS).build());
    }
}
