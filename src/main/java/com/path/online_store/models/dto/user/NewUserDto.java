package com.path.online_store.models.dto.user;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class NewUserDto {
    @NotBlank
    String username;
    @NotBlank
    @Email
    String email;
    @NotBlank
    String password;
    @NotBlank
    @Size(min = 4)
    String nickName;
    /*@NotNull
    @Size(min = 1)
    Set<@Positive Integer> roleIds*/
}
