package com.hcmute.bookstore.mapstruct;

import com.hcmute.bookstore.dtos.category.CategoryReqDto;
import com.hcmute.bookstore.dtos.category.CategoryResDto;
import com.hcmute.bookstore.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "parentId", target = "parent", qualifiedByName = "idParentToParent")
    Category dtoToCategory(CategoryReqDto categoryReqDto);

    @Mapping(source = "parent", target = "parent")
    @Mapping(source = "parent", target = "allParentNames", qualifiedByName = "allParentNames")
    @Mapping(source = "createTime", target = "createTime")
    @Mapping(source = "updateTime", target = "updateTime")
    CategoryResDto categoryToDto(Category category);

    List<CategoryResDto> categoriesToDtos(List<Category> categories);


    @Named("idParentToParent")
    public static Category idParentToParent(Long id) {
        if (id == null) return null;
        return Category.builder().id(id).build();
    }

    @Named("allParentNames")
    public static String allParentNames(Category parent) {
        if (parent == null) return "";
        StringBuilder builder = new StringBuilder();
        builder.append(parent.getName());

        Category temp = parent.getParent();
        while (temp != null) {
            builder.append(" - ").append(temp.getName());
            temp = temp.getParent();
        }

        return builder.toString();
    }
}
