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

    @GetMapping("/startStory/{storyNextID}")
    public StoryDto startStory(@PathVariable int storyNextID) {
        System.out.println("StoryController story id : " +  storyNextID);
        return storyService.startStory(storyNextID);
    }

    @GetMapping("/story/{choice}")
    public StoryDto storyChoice(@PathVariable int choice) {
        return storyService.storyChoice(choice);
    }
}
