package com.hcmute.bookstore.services.impl;

import com.hcmute.bookstore.dtos.category.CategoryReqDto;
import com.hcmute.bookstore.dtos.category.CategoryResDto;
import com.hcmute.bookstore.entities.Category;
import com.hcmute.bookstore.exception.NotfoundException;
import com.hcmute.bookstore.mapstruct.CategoryMapper;
import com.hcmute.bookstore.repositories.CategoryRepository;
import com.hcmute.bookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<CategoryResDto> getAll() {
        return CategoryMapper.INSTANCE.categoriesToDtos(categoryRepo.findAll());
    }

    @Override
    public List<CategoryResDto> getAllLevel3Category() {
        return CategoryMapper.INSTANCE.categoriesToDtos(categoryRepo.findAllLevel3());
    }

    @Override
    public CategoryResDto getCategory(Long id) {
        return CategoryMapper.INSTANCE.categoryToDto(categoryRepo.findById(id)
                .orElseThrow(() -> new NotfoundException("category", "id", id)));
    }

    @Override
    public CategoryResDto addCategory(CategoryReqDto categoryReqDto) {
        Category parent = null;
        if (categoryReqDto.getParentId() != null) {
            parent = categoryRepo.findById(categoryReqDto.getParentId())
                    .orElseThrow(() -> new NotfoundException("category parent", "id", categoryReqDto.getParentId()));
        }
        Category newCategory = CategoryMapper.INSTANCE.dtoToCategory(categoryReqDto);
        newCategory.setParent(parent);
        newCategory.setAllParentIds(generateAllParentIds(parent));
        return CategoryMapper.INSTANCE.categoryToDto(categoryRepo.save(newCategory));
    }

    @Override
    public CategoryResDto updateCategory(Long id, CategoryReqDto categoryReqDto) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new NotfoundException("category", "id", id));

        Category parent = null;
        if (categoryReqDto.getParentId() != null) {
            parent = categoryRepo.findById(categoryReqDto.getParentId()).orElseThrow(
                    () -> new NotfoundException("category parent", "id",
                            categoryReqDto.getParentId()));
        }

        category.setName(categoryReqDto.getName());
        category.setParent(parent);
        category.setAllParentIds(generateAllParentIds(parent));

        return CategoryMapper.INSTANCE.categoryToDto(categoryRepo.save(category));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }

    private String generateAllParentIds(Category parent) {
        if (parent == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        Category temp = parent;
        do {
            builder.append("-").append(temp.getId());
            temp = temp.getParent();
        } while (temp != null);

        return builder.append("-").toString();
    }
}
