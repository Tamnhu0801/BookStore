package com.hcmute.bookstore.mapstruct;

import com.hcmute.bookstore.dtos.role.RoleDto;
import com.hcmute.bookstore.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto roleToDto(Role role);

    List<RoleDto> rolesToDtos(List<Role> roles);

    Role DtoToRole(RoleDto roleDto);
}
