package com.eocoo.mgrportal.service;

import com.eocoo.mgrportal.domain.ReadingNote;
import com.eocoo.mgrportal.domain.ReadingNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingNoteService {
    @Autowired
    private ReadingNoteRepository readingNoteRepository;

    public ReadingNote findById(Long id) {
        Optional<ReadingNote> op = readingNoteRepository.findById(id);
        return op.get();
    }

    public void addReadingNote(ReadingNote note) {
        readingNoteRepository.save(note);
    }

    public void deleteReadingNote(Long id) {
        readingNoteRepository.deleteById(id);
    }

    public void modReadingNote(ReadingNote note) {
        readingNoteRepository.save(note);
    }

    //查
    public List<ReadingNote> findByCondition() {
        return readingNoteRepository.findAll();
    }
}
