package com.example.SpringMVC.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {
    private Long id;

    @Size(min = 2, max = 250)
    private String title;

    @NotBlank
    private String content;
}

