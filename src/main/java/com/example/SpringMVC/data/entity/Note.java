package com.example.SpringMVC.data.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notes")
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;
}
