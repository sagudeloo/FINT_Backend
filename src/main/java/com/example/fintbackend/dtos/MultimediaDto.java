package com.example.fintbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MultimediaDto {

    private Integer id;
    private String title;
    private Integer duration;
    private String url;
    private String author;
    private String date;
}
