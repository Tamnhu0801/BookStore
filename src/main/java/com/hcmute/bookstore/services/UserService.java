package com.hcmute.bookstore.services;

import com.hcmute.bookstore.dtos.user.UserReqDto;
import com.hcmute.bookstore.dtos.user.UserResDto;

import java.util.List;

public interface UserService {
    UserResDto getUser(Long id);

    List<UserResDto> getAllUser();

    UserResDto addUser(UserReqDto userReqDto);

    UserResDto getUserByEmail(String username);

    void deleteUser(Long id);

    UserResDto updateUser(Long id, UserReqDto userReqDto);
}
