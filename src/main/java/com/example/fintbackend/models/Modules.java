package com.example.fintbackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Table(name = "modules")
@With
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Modules implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
}
