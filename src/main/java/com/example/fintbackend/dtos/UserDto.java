package com.example.fintbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;             //PK
    private String name;
    private String email;
    private String password;
    private String role;
}
