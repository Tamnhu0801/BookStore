package com.hcmute.bookstore.services;

import com.hcmute.bookstore.dtos.category.CategoryReqDto;
import com.hcmute.bookstore.dtos.category.CategoryResDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResDto> getAll();

    List<CategoryResDto> getAllLevel3Category();

    CategoryResDto getCategory(Long id);

    CategoryResDto addCategory(CategoryReqDto categoryReqDto);

    CategoryResDto updateCategory(Long id, CategoryReqDto categoryReqDto);

    void deleteCategory(Long id);
}
