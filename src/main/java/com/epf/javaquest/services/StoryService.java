package com.epf.javaquest.services;

import com.epf.javaquest.DAO.HeroDao;
import com.epf.javaquest.DAO.StoryDao;
import com.epf.javaquest.DTO.StoryDto;
import com.epf.javaquest.DTO.StoryMapper;
import com.epf.javaquest.models.Hero;
import com.epf.javaquest.models.Story;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class StoryService {
    private final StoryDao storyDao;
    private final HeroDao heroDao;

    public StoryDto startStory(int storyNextID) {
        System.out.println("StoryService story id : " +  storyNextID);
        Story story =  storyDao.findByDescriptionID(storyNextID);
        System.out.println("StoryService story: " +  story.toString());
        return StoryMapper.toDto(story);
    }

    public StoryDto storyChoice(int choice) {
        Story story = storyDao.findByDescriptionID(choice);
        Map<String, Integer> modifiers = (story.getEffects() != null) ? parseModifiers(story.getEffects()) : new HashMap<>();
        Hero hero = heroDao.findAll().get(0); // update 0 if multiple heroes available
        System.out.println(modifiers);
        hero.updateStats(modifiers.getOrDefault("health_point", 0), modifiers.getOrDefault("attack_point", 0), modifiers.getOrDefault("defense_point", 0), modifiers.getOrDefault("magic_point", 0), modifiers.getOrDefault("speed", 0));
        hero.updateExp(modifiers.getOrDefault("exp", 0));
        heroDao.save(hero);
        return StoryMapper.toDto(story);
    }

    private Map<String, Integer> parseModifiers(String inputModifiers) {
        Map<String, Integer> modifiers = new HashMap<>();
        String[] parts = inputModifiers.split(";");
        for (String part : parts) {
            String[] keyValue = part.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                int value = Integer.parseInt(keyValue[1].trim());
                modifiers.put(key, value);
            }
        }
        return modifiers;
    }
}
