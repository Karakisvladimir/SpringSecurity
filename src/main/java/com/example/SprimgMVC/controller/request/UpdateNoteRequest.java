package com.example.SprimgMVC.controller.request;

public class UpdateNoteRequest extends NoteRequest {
    public UpdateNoteRequest() {
    }

    public UpdateNoteRequest(String title, String content) {
        super(title, content);
    }
}

