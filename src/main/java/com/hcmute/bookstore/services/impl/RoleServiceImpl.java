package com.hcmute.bookstore.services.impl;

import com.hcmute.bookstore.dtos.role.RoleDto;
import com.hcmute.bookstore.entities.Author;
import com.hcmute.bookstore.exception.NotfoundException;
import com.hcmute.bookstore.mapstruct.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmute.bookstore.entities.Role;
import com.hcmute.bookstore.mapstruct.RoleMapper;
import com.hcmute.bookstore.repositories.RoleRepository;
import com.hcmute.bookstore.repositories.UserRepository;
import com.hcmute.bookstore.services.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;

    @Override
    public List<RoleDto> getAllRole() {
        return RoleMapper.INSTANCE.rolesToDtos(roleRepo.findAll());
    }

    @Override
    public RoleDto getRole(Integer id) {
        return RoleMapper.INSTANCE.roleToDto(roleRepo.findOneById(id));
    }

    @Override
    public RoleDto addRole(RoleDto roleDto) {
        Role role = roleRepo.save(RoleMapper.INSTANCE.DtoToRole(roleDto));
        return RoleMapper.INSTANCE.roleToDto(roleRepo.save(role));
    }

    @Override
    public void deleteRole(Integer id) {
        roleRepo.delete(roleRepo.findOneById(id));
    }

    @Override
    public RoleDto updateRole(Integer id, RoleDto roleDto) {
        Role role = roleRepo.findById(id)
                .orElseThrow(() -> new NotfoundException("role", "id", id));
        role.setName(roleDto.getName());
        return RoleMapper.INSTANCE.roleToDto(roleRepo.save(role));
    }

//    @Override
//    public Object addUserToRole(UserRoleDto userRoleDto) {
//        Role role = roleRepo.findOneById(userRoleDto.getRole_id());
//        User user = userRepo.findOneById(userRoleDto.getUser_id());
//
//        role.getUser().add(user);
//        user.getRoles().add(role);
//
//        roleRepo.save(role);
//        userRepo.save(user);
//
//        return userRoleDto;
//    }
}
