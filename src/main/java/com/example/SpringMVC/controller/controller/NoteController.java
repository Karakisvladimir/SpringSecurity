package com.example.SpringMVC.controller.controller;



import com.example.SpringMVC.service.NoteService;
import com.example.SpringMVC.service.components.NoteMapper;
import com.example.SpringMVC.service.dto.NoteDto;
import com.example.SpringMVC.service.exception.NoteNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Validated
@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;
    @Autowired private NoteMapper noteMapper;

    @GetMapping
    public String getMainPage(Model model) throws NoteNotFoundException {
        model.addAttribute("notes", noteMapper.toNoteResponses(noteService.findAll()));

        return "notes/mainNotePage";
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute @Valid NoteDto noteDto, RedirectAttributes redirectAttributes) {
        noteService.save(noteDto);
        redirectAttributes.addFlashAttribute("successMessage", "Note created successfully");

        return "redirect:/note";
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public ModelAndView noteList() throws NoteNotFoundException {
        ModelAndView result = new ModelAndView("notes/listNotes");
        result.addObject("notes", noteMapper.toNoteResponses(noteService.findAll()));

        return result;
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.GET})
    public ModelAndView getNoteForEdit(@NotEmpty @RequestParam(value="id") String id) throws NoteNotFoundException {
        Long noteId = Long.valueOf(id);
        ModelAndView result = new ModelAndView("notes/updateNote");
        result.addObject("note", noteMapper.toNoteResponse(noteService.findById(noteId)));

        return result;
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public ModelAndView updateNote(
            @NotEmpty @RequestParam(value="id") String id,
            @Size(min = 1, max = 250) @RequestParam(value="title") String title,
            @NotEmpty @RequestParam(value="content") String content) throws NoteNotFoundException {
        NoteDto dto = new NoteDto();
        dto.setId(Long.valueOf(id));
        dto.setTitle(title);
        dto.setContent(content);
        noteService.update(dto);

        return noteList();
    }

    @DeleteMapping("/delete")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public ModelAndView deleteNoteById(@Valid @NotNull @RequestParam(value="id") String id) throws NoteNotFoundException {
        noteService.deleteById(Long.valueOf(id));

        return noteList();
    }
}