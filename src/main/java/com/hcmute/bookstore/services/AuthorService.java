package com.hcmute.bookstore.services;

import com.hcmute.bookstore.dtos.author.AuthorReqDto;
import com.hcmute.bookstore.dtos.author.AuthorResDto;
import java.util.List;

public interface AuthorService {
    List<AuthorResDto> getAll();

    AuthorResDto getAuthor(Long id);

    AuthorResDto addAuthor(AuthorReqDto authorReqDto);

    AuthorResDto updateAuthor(Long id, AuthorReqDto authorReqDto);

    void deleteAuthor(Long id);
}
