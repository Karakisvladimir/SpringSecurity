package com.example.SprimgMVC.service.components;

import com.example.SprimgMVC.controller.request.CreateNoteRequest;
import com.example.SprimgMVC.controller.request.UpdateNoteRequest;
import com.example.SprimgMVC.controller.response.NoteResponse;
import com.example.SprimgMVC.service.dto.NoteDto;
import com.example.SprimgMVC.data.entity.Note;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class NoteMapper {
    public List<Note> toNotes(Collection<NoteDto> noteDtos) {
        return noteDtos.stream()
                .map(this::toNote)
                .collect(Collectors.toList());
    }

    public Note toNote(NoteDto noteDto) {
        Note note = new Note();
        note.setId(noteDto.getId());
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        return note;
    }

    public List<NoteDto> toNoteDtos(Collection<Note> notes) {
        return notes.stream()
                .map(this::toNoteDto)
                .collect(Collectors.toList());
    }

    public NoteDto toNoteDto(Note note) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(note.getId());
        noteDto.setTitle(note.getTitle());
        noteDto.setContent(note.getContent());
        return noteDto;
    }

    public List<NoteResponse> toNoteResponses(Collection<NoteDto> noteDtos) {
        return noteDtos.stream()
                .map(this::toNoteResponse)
                .collect(Collectors.toList());
    }

    public NoteResponse toNoteResponse(NoteDto noteDto) {
        NoteResponse response = new NoteResponse();
        response.setId(noteDto.getId());
        response.setTitle(noteDto.getTitle());
        response.setContent(noteDto.getContent());
        return response;
    }

    public List<NoteDto> requestsToNoteDtos(Collection<CreateNoteRequest> requests) {
        return requests.stream()
                .map(this::toNoteDto)
                .collect(Collectors.toList());
    }

    public NoteDto toNoteDto(CreateNoteRequest request) {
        NoteDto noteDto = new NoteDto();
        noteDto.setTitle(request.getTitle());
        noteDto.setContent(request.getContent());
        return noteDto;
    }

    public NoteDto toNoteDto(UUID id, UpdateNoteRequest request) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(id);
        noteDto.setTitle(request.getTitle());
        noteDto.setContent(request.getContent());
        return noteDto;
    }
}

