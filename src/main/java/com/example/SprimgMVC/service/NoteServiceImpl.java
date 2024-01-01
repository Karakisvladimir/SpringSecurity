package com.example.SprimgMVC.service;

import com.example.SprimgMVC.data.repositoriy.NoteRepositoriy;
import com.example.SprimgMVC.service.components.NoteMapper;
import com.example.SprimgMVC.service.dto.NoteDto;
import com.example.SprimgMVC.service.exception.NoteNotFoundException;
import com.example.SprimgMVC.data.entity.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class NoteServiceImpl implements NoteService{
 @Autowired
 private NoteRepositoriy noteRepository;
    @Autowired private NoteMapper noteMapper;

    @Override
    public NoteDto save(NoteDto noteDto) {
        Note note = noteMapper.toNote(noteDto);
        note.setId(null);
        return noteMapper.toNoteDto(noteRepository.save(note));
    }

    @Override
    public void update(NoteDto noteDto) throws NoteNotFoundException {
        if (Objects.isNull(noteDto.getId())) {
            throw new NoteNotFoundException();
        }
        findById(noteDto.getId());
        noteRepository.save(noteMapper.toNote(noteDto));
    }

    @Override
    public NoteDto findById(UUID id) throws NoteNotFoundException {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            return noteMapper.toNoteDto(optionalNote.get());
        } else {
            throw new NoteNotFoundException(id);
        }
    }

    @Override
    public List<NoteDto> findAll() throws NoteNotFoundException {
        return noteMapper.toNoteDtos(noteRepository.findAll());
    }

    @Override
    public void deleteById(UUID id) throws NoteNotFoundException {
        findById(id);
        noteRepository.deleteById(id);
    }
}
