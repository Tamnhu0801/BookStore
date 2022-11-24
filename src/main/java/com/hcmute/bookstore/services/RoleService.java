package com.hcmute.bookstore.services;

import com.hcmute.bookstore.dtos.role.RoleDto;

import java.util.List;

public interface RoleService {

    List<RoleDto> getAllRole();

    RoleDto getRole(Integer id);

    RoleDto addRole(RoleDto roleDto);

    void deleteRole(Integer id);

    RoleDto updateRole(Integer id, RoleDto roleDto);

//    Object addUserToRole(UserRoleDto userRoleDto);

}
