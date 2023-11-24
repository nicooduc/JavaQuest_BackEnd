package com.epf.javaquest.controllers;

import com.epf.javaquest.DTO.StoryDto;
import com.epf.javaquest.models.Story;
import com.epf.javaquest.services.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("story")
@RestController
@RequiredArgsConstructor
public class StoryController {
    private final StoryService storyService;

    //TODO startStory doit pouvoir reprendre le dernier id
    @GetMapping("/startStory")
    public Story startStory() {
        return storyService.startStory();
    }

    @GetMapping("/story/{choice}")
    public Story storyChoice(@PathVariable int choice) {
        return storyService.storyChoice(choice);
    }

    // TODO touts les objets sont sensé être des DTO ici
}
