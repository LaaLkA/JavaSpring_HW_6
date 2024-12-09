package org.laalka.javaspring_hw_6.service;

import org.laalka.javaspring_hw_6.model.Note;

import java.util.List;

public interface NoteService {

    List<Note> getAllNotes();

    Note getNoteById(Long id);

    Note createNote(Note note);

    Note updateNote(Note note);

    void deleteNote(Long id);

}
