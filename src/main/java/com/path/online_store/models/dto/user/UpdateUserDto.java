package com.path.online_store.models.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateUserDto {
    @NotBlank
    @Email
    String email;
    @NotBlank
    String nickName;
}
