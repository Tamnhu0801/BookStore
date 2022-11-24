package com.hcmute.bookstore.controllers;

import com.hcmute.bookstore.dtos.category.CategoryReqDto;
import com.hcmute.bookstore.entities.ResponseObject;
import com.hcmute.bookstore.services.CategoryService;
import com.hcmute.bookstore.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(categoryService.getAll()).build());
    }

    @GetMapping(value = "/level-3")
    public ResponseEntity<ResponseObject> getAllLevel3Category() {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(categoryService.getAllLevel3Category()).build());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> getCategory(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(categoryService.getCategory(id)).build());
    }

    @PostMapping
    public ResponseEntity<ResponseObject> addCategory(@RequestBody CategoryReqDto categoryReqDto) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(categoryService.addCategory(categoryReqDto)).build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> updateCategory(@PathVariable(name = "id") Long id,
                                                         @RequestBody CategoryReqDto categoryReqDto) {
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS)
                        .data(categoryService.updateCategory(id, categoryReqDto)).build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> deleteCategory(@PathVariable(name = "id") Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().body(
                ResponseObject.builder().status(HttpStatus.OK).message(Constant.SUCCESS).build());
    }
}
