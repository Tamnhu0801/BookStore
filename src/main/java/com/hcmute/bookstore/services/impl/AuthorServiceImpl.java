package com.hcmute.bookstore.services.impl;

import com.hcmute.bookstore.dtos.author.AuthorReqDto;
import com.hcmute.bookstore.dtos.author.AuthorResDto;
import com.hcmute.bookstore.entities.Author;
import com.hcmute.bookstore.exception.NotfoundException;
import com.hcmute.bookstore.mapstruct.AuthorMapper;
import com.hcmute.bookstore.repositories.AuthorRepository;
import com.hcmute.bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepo;
    @Override
    public List<AuthorResDto> getAll() {
        return AuthorMapper.INSTANCE.authorsToDtos(authorRepo.findAll());
    }

    @Override
    public AuthorResDto getAuthor(Long id) {
        return AuthorMapper.INSTANCE.authorToDto(authorRepo.findById(id)
                .orElseThrow(() -> new NotfoundException("author", "id", id)));
    }

    @Override
    public AuthorResDto addAuthor(AuthorReqDto authorReqDto) {
        Author author = authorRepo.save(AuthorMapper.INSTANCE.dtoToAuthor(authorReqDto));
        return AuthorMapper.INSTANCE.authorToDto(authorRepo.save(author));
    }

    @Override
    public AuthorResDto updateAuthor(Long id, AuthorReqDto authorReqDto) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new NotfoundException("author", "id", id));
        author.setName(authorReqDto.getName());
        author.setInfo(authorReqDto.getInfo());
        return AuthorMapper.INSTANCE.authorToDto(authorRepo.save(author));
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepo.deleteById(id);
    }
}
