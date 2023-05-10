package com.example.fintbackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Table(name="subjects")
@With
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subjects implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer progress;
    private Integer moduleId;
}
