package com.example.fintbackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Table(name = "multimedia")
@With
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Multimedia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer duration;
    private String url;
    private String author;
    private String date;
}

