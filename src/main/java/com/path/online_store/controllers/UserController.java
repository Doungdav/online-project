package com.path.online_store.controllers;

import com.path.online_store.models.dto.user.IsDeletedDto;
import com.path.online_store.models.dto.user.NewUserDto;
import com.path.online_store.models.dto.user.UpdateUserDto;
import com.path.online_store.models.dto.user.UserDto;
import com.path.online_store.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void newUserDto(@RequestBody @Valid NewUserDto newUserDto){
        userService.createNewUser(newUserDto);
    }

    @PatchMapping("/{uuid}")
    void updateByUuid(@PathVariable String uuid,
                      @RequestBody UpdateUserDto updateUserDto){
        userService.updateByUuid(uuid, updateUserDto);
    }

    @GetMapping("/{uuid}")
    UserDto findByUuid(@PathVariable String uuid){
       return userService.findByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    void deleteByUuid(@PathVariable String uuid){
        userService.deleteByUuid(uuid);
    }

    @PutMapping("/{uuid}")
    public void updateIsDeletedByUuid(@PathVariable String uuid,
                                      @RequestBody IsDeletedDto isDeletedDto){
        userService.updateIsDeletedByUuid(uuid, isDeletedDto.isDeleted);

    }



}
