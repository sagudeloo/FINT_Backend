package com.example.fintbackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@Table(name="users_modules")
@With
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersModules implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer moduleId;
    private Integer progress;
}
