package com.example.jwtsecuritydemo.converter;

import org.mapstruct.Mapper;

import com.example.jwtsecuritydemo.entity.UserEntity;
import com.example.jwtsecuritydemo.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserEntity toUserEntity(User user);

	User toUserModel(UserEntity entity);

}
