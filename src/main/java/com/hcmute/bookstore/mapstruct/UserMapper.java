package com.hcmute.bookstore.mapstruct;

import com.hcmute.bookstore.dtos.user.UserReqDto;
import com.hcmute.bookstore.dtos.user.UserResDto;
import com.hcmute.bookstore.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToUser(UserReqDto dto);

    UserResDto userToDto(User user);

    List<UserResDto> usersToDtos(List<User> users);
}
