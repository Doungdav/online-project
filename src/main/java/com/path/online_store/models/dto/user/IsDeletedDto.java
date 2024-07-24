package com.path.online_store.models.dto.user;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IsDeletedDto {
    @NotNull
    public Boolean isDeleted;


}
