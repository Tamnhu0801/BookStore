package com.hcmute.bookstore.services.impl;

import com.hcmute.bookstore.dtos.user.UserReqDto;
import com.hcmute.bookstore.dtos.user.UserResDto;
import com.hcmute.bookstore.entities.Role;
import com.hcmute.bookstore.entities.User;
import com.hcmute.bookstore.exception.NotfoundException;
import com.hcmute.bookstore.mapstruct.UserMapper;
import com.hcmute.bookstore.repositories.RoleRepository;
import com.hcmute.bookstore.repositories.UserRepository;
import com.hcmute.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserResDto> getAllUser() {
        return UserMapper.INSTANCE.usersToDtos(userRepo.findAll());
    }

    @Override
    public UserResDto getUser(Long id) {
        return UserMapper.INSTANCE.userToDto(
                userRepo.findById(id).orElseThrow(() -> new NotfoundException("user", "id", id)));
    }

    @Override
    public UserResDto getUserByEmail(String email) {
        return UserMapper.INSTANCE.userToDto(
                userRepo.findByEmail(email)
                        .orElseThrow(() -> new NotfoundException("user", "email", email)));
    }


    @Override
    @Transactional
    public UserResDto addUser(UserReqDto userReqDto) {
        if (userRepo.findByEmail(userReqDto.getEmail()).isPresent()) {
            throw new NotfoundException("user", "email", userReqDto.getEmail());
        }


        Set<Role> roles = userReqDto.getRoleIds().stream().map(rId -> roleRepo.findById(rId)
                        .orElseThrow(() -> new NotfoundException("role", "id", rId)))
                .collect(Collectors.toSet());

        User newUser = UserMapper.INSTANCE.dtoToUser(userReqDto);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        newUser.setRoles(roles);
        newUser.setEnabled(true);

        return UserMapper.INSTANCE.userToDto(userRepo.saveAndFlush(newUser));
    }

    @Override
    @Transactional
    public UserResDto updateUser(Long id, UserReqDto userReqDto) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new NotfoundException("user", "id", id));

        Optional<User> userBeGetByEmailOptional = userRepo.findByEmail(userReqDto.getEmail());
        if (userBeGetByEmailOptional.isPresent()) {
            User userBeGetByEmail = userBeGetByEmailOptional.get();

            if (!user.equals(userBeGetByEmail)) {
                throw new NotfoundException("user", "email", userReqDto.getEmail());
            }
        }


        Set<Role> roles = userReqDto.getRoleIds().stream().map(rId -> roleRepo.findById(rId)
                        .orElseThrow(() -> new NotfoundException("role", "id", rId)))
                .collect(Collectors.toSet());

        user.setEmail(userReqDto.getEmail());
        user.setUsername(userReqDto.getUsername());
        user.setFullname(userReqDto.getFullname());
        user.setEnabled(userReqDto.isEnabled());

        if (userReqDto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userReqDto.getPassword()));
        }

        user.setRoles(roles);

        return UserMapper.INSTANCE.userToDto(userRepo.save(user));
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
