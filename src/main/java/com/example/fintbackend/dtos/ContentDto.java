package com.example.fintbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentDto {
    private Integer id;             //PK
    private String title;
    private String text;
    private Integer subjectId;      //FK
}
