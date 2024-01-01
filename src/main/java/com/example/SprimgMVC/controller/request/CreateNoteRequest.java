package com.example.SprimgMVC.controller.request;

import lombok.Data;

@Data
public class CreateNoteRequest extends NoteRequest {
    public CreateNoteRequest () {
    }

    public CreateNoteRequest (String title, String content) {
        super(title, content);
    }
}
