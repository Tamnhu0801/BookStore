package com.hcmute.bookstore.controllers;

import com.hcmute.bookstore.dtos.company.CompanyReqDto;
import com.hcmute.bookstore.entities.ResponseObject;
import com.hcmute.bookstore.services.CompanyService;
import com.hcmute.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins = "*")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(companyService.getAll()).build());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> getCompany(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(companyService.getCompany(id)).build());
    }

    @PostMapping
    public ResponseEntity<ResponseObject> addCompany(@RequestBody CompanyReqDto companyReqDto) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(companyService.addCompany(companyReqDto)).build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> updateCompany(@PathVariable(name = "id") Long id,
                                                        @RequestBody CompanyReqDto companyReqDto) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(companyService.updateCompany(id, companyReqDto)).build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> deleteCompany(@PathVariable(name = "id") Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS).build());
    }
}
