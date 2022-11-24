package com.hcmute.bookstore.controllers;

import com.hcmute.bookstore.entities.ResponseObject;
import com.hcmute.bookstore.services.UserService;
import com.hcmute.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/myInfo")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ResponseObject> getInfo(Principal principal) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(userService.getUserByEmail(principal.getName())).build());
    }

}
