package org.laalka.javaspring_hw_6.controller;

import lombok.RequiredArgsConstructor;
import org.laalka.javaspring_hw_6.model.Note;
import org.laalka.javaspring_hw_6.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService service;

    @GetMapping
    public ResponseEntity<List<Note>> findAll() {
        return new ResponseEntity<>(service.getAllNotes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(service.createNote(note), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable("id") Long id) {
        Note noteById = service.getNoteById(id);
        if (noteById == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        } else {
            return new ResponseEntity<>(noteById, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        return new ResponseEntity<>(service.updateNote(note), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id) {
        service.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
