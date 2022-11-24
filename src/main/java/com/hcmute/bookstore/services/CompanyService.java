package com.hcmute.bookstore.services;

import com.hcmute.bookstore.dtos.author.AuthorReqDto;
import com.hcmute.bookstore.dtos.author.AuthorResDto;
import com.hcmute.bookstore.dtos.company.CompanyReqDto;
import com.hcmute.bookstore.dtos.company.CompanyResDto;

import java.util.List;

public interface CompanyService {
    List<CompanyResDto> getAll();

    CompanyResDto getCompany(Long id);

    CompanyResDto addCompany(CompanyReqDto companyReqDto);

    CompanyResDto updateCompany(Long id, CompanyReqDto companyReqDto);

    void deleteCompany(Long id);
}
