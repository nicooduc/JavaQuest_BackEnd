package com.epf.javaquest.controllers;

import com.epf.javaquest.DTO.StoryDto;
import com.epf.javaquest.services.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("story")
@RestController
@RequiredArgsConstructor
public class StoryController {
    private final StoryService storyService;

    // Démarre une nouvelle histoire à partir d'une ID spécifique
    @GetMapping("/startStory/{storyNextID}")
    public StoryDto startStory(@PathVariable int storyNextID) {
        return storyService.startStory(storyNextID);
    }

    // Effectue un choix dans l'histoire en fonction de l'ID de la redirection
    @GetMapping("/story/{choice}")
    public StoryDto storyChoice(@PathVariable int choice) {
        return storyService.storyChoice(choice);
    }
}
