package com.example.SprimgMVC.service;

import com.example.SprimgMVC.service.dto.NoteDto;
import com.example.SprimgMVC.service.exception.NoteNotFoundException;

import java.util.List;
import java.util.UUID;

public interface NoteService {
    NoteDto save(NoteDto note);

    void update(NoteDto note) throws NoteNotFoundException;

    NoteDto findById(UUID id)  throws NoteNotFoundException;

    List<NoteDto> findAll()  throws NoteNotFoundException;

    void deleteById(UUID id)  throws NoteNotFoundException, NoteNotFoundException;
}

