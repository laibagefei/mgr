package com.eocoo.mgrportal.controller;

import com.eocoo.mgrportal.domain.ReadingNote;
import com.eocoo.mgrportal.service.ReadingNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/readnote")
public class ReadingNoteController {

    @Autowired
    private ReadingNoteService readingNoteService;

    @RequestMapping("")
    public String home() {
        return "readnote/index";
    }

    //Add
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String addReadNote(@ModelAttribute ReadingNote note) {
        readingNoteService.addReadingNote(note);

        return "readnote/index";
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteReadNote(@PathVariable long id) {
        readingNoteService.deleteReadingNote(id);
        return "readnote/index";
    }

    //Put
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String modReadNote(@ModelAttribute ReadingNote note) {
        readingNoteService.modReadingNote(note);

        return "readnote/show";
    }

    //Get
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getReadNote(@PathVariable long id, ModelMap map) {
        ReadingNote note = readingNoteService.findById(id);
        map.addAttribute("user", note);

        return "readnote/show";
    }

    //Search
    @RequestMapping("/search")
    public String search(ModelMap map) {
        List<ReadingNote> res = readingNoteService.findByCondition();
        map.addAttribute("res", res);
        return "readnote/index";
    }

}
