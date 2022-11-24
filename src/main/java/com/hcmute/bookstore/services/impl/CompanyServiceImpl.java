package com.hcmute.bookstore.services.impl;

import com.hcmute.bookstore.dtos.company.CompanyReqDto;
import com.hcmute.bookstore.dtos.company.CompanyResDto;
import com.hcmute.bookstore.entities.Company;
import com.hcmute.bookstore.exception.NotfoundException;
import com.hcmute.bookstore.mapstruct.CompanyMapper;
import com.hcmute.bookstore.repositories.CompanyRepository;
import com.hcmute.bookstore.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepo;

    @Override
    public List<CompanyResDto> getAll() {
        return CompanyMapper.INSTANCE.companiesToDtos(companyRepo.findAll());
    }

    @Override
    public CompanyResDto getCompany(Long id) {
        return CompanyMapper.INSTANCE.companyToDto(companyRepo.findById(id)
                .orElseThrow(() -> new NotfoundException("company", "id", id)));
    }

    @Override
    public CompanyResDto addCompany(CompanyReqDto companyReqDto) {
        Company company = companyRepo.save(CompanyMapper.INSTANCE.dtoToCompany(companyReqDto));
        return CompanyMapper.INSTANCE.companyToDto(companyRepo.save(company));
    }

    @Override
    public CompanyResDto updateCompany(Long id, CompanyReqDto companyReqDto) {
        Company company = companyRepo.findById(id)
                .orElseThrow(() -> new NotfoundException("company", "id", id));
        company.setName(companyReqDto.getName());
        company.setInfo(companyReqDto.getInfo());
        return CompanyMapper.INSTANCE.companyToDto(companyRepo.save(company));
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepo.deleteById(id);
    }
}
