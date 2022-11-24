package com.hcmute.bookstore.services;

import com.hcmute.bookstore.dtos.book.BookReqDto;
import com.hcmute.bookstore.dtos.book.BookResDto;

import java.util.List;

public interface BookService {
    List<BookResDto> getAll();

    BookResDto getBook(Long id);

    BookResDto addBook(BookReqDto bookReqDto);

    BookResDto updateBook(Long id, BookReqDto bookReqDto);

    void deleteBook(Long id);

    long getQuantity();
}
