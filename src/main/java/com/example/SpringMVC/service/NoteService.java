package com.example.SpringMVC.service;

import com.example.SpringMVC.service.dto.NoteDto;
import com.example.SpringMVC.service.exception.NoteNotFoundException;

import java.util.List;


public interface NoteService {
    NoteDto save(NoteDto note);

    void update(NoteDto note) throws NoteNotFoundException;

    NoteDto findById(Long id)  throws NoteNotFoundException;

    List<NoteDto> findAll()  throws NoteNotFoundException;

    void deleteById(Long id)  throws NoteNotFoundException;
}

