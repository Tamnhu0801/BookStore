package com.hcmute.bookstore.services.impl;

import com.hcmute.bookstore.dtos.book.BookReqDto;
import com.hcmute.bookstore.dtos.book.BookResDto;
import com.hcmute.bookstore.entities.Author;
import com.hcmute.bookstore.entities.Book;
import com.hcmute.bookstore.entities.Category;
import com.hcmute.bookstore.entities.Company;
import com.hcmute.bookstore.exception.AlreadyExistsException;
import com.hcmute.bookstore.exception.NotfoundException;
import com.hcmute.bookstore.mapstruct.BookMapper;
import com.hcmute.bookstore.repositories.AuthorRepository;
import com.hcmute.bookstore.repositories.BookRepository;
import com.hcmute.bookstore.repositories.CategoryRepository;
import com.hcmute.bookstore.repositories.CompanyRepository;
import com.hcmute.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private AuthorRepository authorRepo;

    @Autowired
    private CompanyRepository companyRepo;

    @Override
    public List<BookResDto> getAll() {
        return BookMapper.INSTANCE.booksToDtos(bookRepo.findAll());
    }

    @Override
    public BookResDto getBook(Long id) {
        return BookMapper.INSTANCE.bookToDto(bookRepo.findById(id)
                .orElseThrow(() -> new NotfoundException("book", "id", id)));
    }

    @Override
    public BookResDto addBook(BookReqDto bookReqDto) {
        if(bookRepo.findByName(bookReqDto.getName()).isPresent()) {
            throw new AlreadyExistsException("book", "name", bookReqDto.getName());
        }

        Category category = categoryRepo.findById(bookReqDto.getCategoryId())
                .orElseThrow(() -> new NotfoundException("category", "id", bookReqDto.getCategoryId()));

        Author author = authorRepo.findById(bookReqDto.getAuthorId())
                .orElseThrow(() -> new NotfoundException("author", "id", bookReqDto.getAuthorId()));

        Company company = companyRepo.findById(bookReqDto.getCompanyId())
                .orElseThrow(() -> new NotfoundException("company", "id", bookReqDto.getCompanyId()));

        Book book = BookMapper.INSTANCE.dtoToBook(bookReqDto);
        book.setCategory(category);
        book.setAuthor(author);
        book.setCompany(company);

        bookRepo.save(book);

        return BookMapper.INSTANCE.bookToDto(book);
    }

    @Override
    public BookResDto updateBook(Long id, BookReqDto bookReqDto) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new NotfoundException("book", "id", id));

        bookRepo.findByName(bookReqDto.getName())
                .map(b -> {
                    if (!b.equals(book)) {
                        throw new AlreadyExistsException("book", "name", bookReqDto.getName());
                    }
                    return b;
                });

        Category category = categoryRepo.findById(bookReqDto.getCategoryId())
                .orElseThrow(() -> new NotfoundException("category", "id", bookReqDto.getCategoryId()));

        Author author = authorRepo.findById(bookReqDto.getAuthorId())
                .orElseThrow(() -> new NotfoundException("author", "id", bookReqDto.getAuthorId()));

        Company company = companyRepo.findById(bookReqDto.getCompanyId())
                .orElseThrow(() -> new NotfoundException("company", "id", bookReqDto.getCompanyId()));

        BookMapper.INSTANCE.updateBookFromDto(bookReqDto, book);
        book.setCompany(company);
        book.setCategory(category);
        book.setAuthor(author);

        return BookMapper.INSTANCE.bookToDto(bookRepo.save(book));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public long getQuantity() {
        return bookRepo.count();
    }
}
