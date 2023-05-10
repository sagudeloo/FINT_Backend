package com.example.fintbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModuleDto {
    private Integer id;         //PK
    private Integer userId;     //FK
    private Integer moduleId;   //Fk
    private Integer progress;
}
