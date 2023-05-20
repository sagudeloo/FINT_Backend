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

    private Integer id;             //PK
    private String title;
    private String url;
    private Integer duration;
    private Integer contentId;      //FK

}
