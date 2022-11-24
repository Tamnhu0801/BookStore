package com.hcmute.bookstore.mapstruct;

import com.hcmute.bookstore.dtos.book.BookReqDto;
import com.hcmute.bookstore.dtos.book.BookResDto;
import com.hcmute.bookstore.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "status", target = "status")
    @Mapping(expression = "java(CategoryMapper.INSTANCE.categoryToDto(book.getCategory()))",
            target = "category")
    @Mapping(expression = "java(AuthorMapper.INSTANCE.authorToDto(book.getAuthor()))",
            target = "author")
    @Mapping(expression = "java(CompanyMapper.INSTANCE.companyToDto(book.getCompany()))",
            target = "company")
    BookResDto bookToDto(Book book);

    List<BookResDto> booksToDtos(List<Book> book);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "coverPrice", target = "coverPrice")
    @Mapping(source = "price", target = "price")
    @Mapping(ignore = true, target = "author")
    @Mapping(ignore = true, target = "company")
    @Mapping(ignore = true, target = "category")
    Book dtoToBook(BookReqDto bookReqDto);

    @Mapping(ignore = true, target = "id")
    void updateBookFromDto(BookReqDto bookReqDto, @MappingTarget Book book);
}
