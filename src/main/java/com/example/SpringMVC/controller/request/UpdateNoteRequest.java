package com.example.SpringMVC.controller.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateNoteRequest extends NoteRequest {
    public UpdateNoteRequest() {
    }

    public UpdateNoteRequest(String title, String content) {
        super(title, content);
    }
}

