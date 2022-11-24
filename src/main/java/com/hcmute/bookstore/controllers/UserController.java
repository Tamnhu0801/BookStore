package com.hcmute.bookstore.controllers;

import com.hcmute.bookstore.dtos.user.UserReqDto;
import com.hcmute.bookstore.entities.ResponseObject;
import com.hcmute.bookstore.services.UserService;
import com.hcmute.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.ok().body(ResponseObject.builder().status(HttpStatus.OK).message(
                Constant.SUCCESS).data(userService.getAllUser()).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getUser(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(ResponseObject.builder().status(HttpStatus.OK).message(
                Constant.SUCCESS).data(userService.getUser(id)).build());
    }

    @PostMapping()
    public ResponseEntity<ResponseObject> addUser(@RequestBody UserReqDto userReqDto) {
        return ResponseEntity.ok().body(ResponseObject.builder().status(HttpStatus.OK).message(
                Constant.SUCCESS).data(userService.addUser(userReqDto)).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body(ResponseObject.builder().status(HttpStatus.OK).message(
                Constant.SUCCESS).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateUser(@PathVariable(value = "id") Long id, @RequestBody UserReqDto userReqDto) {
        return ResponseEntity.ok().body(ResponseObject.builder().status(HttpStatus.OK).message(
                Constant.SUCCESS).data(userService.updateUser(id, userReqDto)).build());
    }
}
