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
    private int id;             //PK
    private String title;
    private String content;
    private int subjectId;      //FK
    private int multimediaId;   //FK
}
