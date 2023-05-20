package com.example.fintbackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Table(name = "multimedias")
@With
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Multimedias implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String url;
    private Integer duration;
    private Integer contentId;
}

