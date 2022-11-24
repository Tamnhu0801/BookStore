package com.hcmute.bookstore.mapstruct;

import com.hcmute.bookstore.dtos.author.AuthorReqDto;
import com.hcmute.bookstore.dtos.author.AuthorResDto;
import com.hcmute.bookstore.dtos.category.CategoryReqDto;
import com.hcmute.bookstore.dtos.category.CategoryResDto;
import com.hcmute.bookstore.entities.Author;
import com.hcmute.bookstore.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author dtoToAuthor(AuthorReqDto authorReqDto);

    AuthorResDto authorToDto(Author author);

    List<AuthorResDto> authorsToDtos(List<Author> authors);
}
