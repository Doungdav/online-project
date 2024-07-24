package com.path.online_store.services.interfaces;

import com.path.online_store.models.dto.user.NewUserDto;
import com.path.online_store.models.dto.user.UpdateUserDto;
import com.path.online_store.models.dto.user.UserDto;
import com.path.online_store.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void createNewUser(NewUserDto newUserDto) {

    }

    @Override
    public void updateByUuid(String uuid, UpdateUserDto updateUserDto) {

    }

    @Override
    public UserDto findByUuid(String uuid) {
        return null;
    }

    @Override
    public void deleteByUuid(String uuid) {

    }

    @Override
    public void updateIsDeletedByUuid(String uuid, Boolean isDeleted) {

    }
}
