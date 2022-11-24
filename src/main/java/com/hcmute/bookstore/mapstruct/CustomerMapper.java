package com.hcmute.bookstore.mapstruct;

import com.hcmute.bookstore.dtos.customer.CustomerResDto;
import com.hcmute.bookstore.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "enabled", target = "enabled")
    CustomerResDto customerToDto(Customer customer);

    List<CustomerResDto> customersToDtos(List<Customer> customers);
}
