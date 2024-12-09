package org.laalka.javaspring_hw_6.service.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.laalka.javaspring_hw_6.model.Note;
import org.laalka.javaspring_hw_6.repository.NoteRepository;
import org.laalka.javaspring_hw_6.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repository;

    @Override
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        Optional<Note> noteFindById = repository.findById(id);
        if (noteFindById.isPresent()) {
            return noteFindById.get();
        }else {
            throw new IllegalArgumentException("Note not found");
        }
    }

    @Override
    public Note createNote(Note note) {
        return repository.save(note);
    }

    @Override
    public Note updateNote(Note note) {
        Note noteNew = repository.findById(note.getId()).get();
        if (noteNew != null) {
            noteNew.setTitle(note.getTitle());
            noteNew.setContent(note.getContent());
            return repository.save(noteNew);
        }else {
            throw new IllegalArgumentException("Note not found");
        }
    }

    @Override
    public void deleteNote(Long id) {
        Note note = repository.findById(id).get();
        if (note != null) {
            repository.delete(note);
        }else {
            throw new IllegalArgumentException("Note not found");
        }
    }
}
