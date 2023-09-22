package com.easy.skin_diseases_backend.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
