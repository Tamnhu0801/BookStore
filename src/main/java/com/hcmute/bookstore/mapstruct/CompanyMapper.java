package com.hcmute.bookstore.mapstruct;

import com.hcmute.bookstore.dtos.author.AuthorReqDto;
import com.hcmute.bookstore.dtos.author.AuthorResDto;
import com.hcmute.bookstore.dtos.company.CompanyReqDto;
import com.hcmute.bookstore.dtos.company.CompanyResDto;
import com.hcmute.bookstore.entities.Author;
import com.hcmute.bookstore.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company dtoToCompany(CompanyReqDto companyReqDto);

    CompanyResDto companyToDto(Company company);

    List<CompanyResDto> companiesToDtos(List<Company> companies);
}
