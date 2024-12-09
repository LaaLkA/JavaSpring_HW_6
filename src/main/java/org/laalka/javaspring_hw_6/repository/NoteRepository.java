package org.laalka.javaspring_hw_6.repository;

import org.laalka.javaspring_hw_6.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
