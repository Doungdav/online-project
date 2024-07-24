package com.path.online_store.models.mappers;

import com.path.online_store.models.dao.entities.User;
import com.path.online_store.models.dto.user.NewUserDto;
import com.path.online_store.models.dto.user.UpdateUserDto;
import com.path.online_store.models.dto.user.UserDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    User fromNewUserDto(NewUserDto newUserDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateUserDto(@MappingTarget User user, UpdateUserDto updateUserDto);
}
