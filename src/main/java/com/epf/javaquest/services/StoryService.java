package com.epf.javaquest.services;

import com.epf.javaquest.DAO.HeroDao;
import com.epf.javaquest.DAO.StoryDao;
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

    public Story startStory() {
        return storyDao.findByDescriptionID(1);
    }

    public Story storyChoice(int choice) {
        Story story = storyDao.findByDescriptionID(choice);
        Map<String, Integer> modifiers = (story.getEffects() != null) ? parseModifiers(story.getEffects()) : new HashMap<>();
        Hero hero = heroDao.findAll().get(0); //TODO  avoir plusieurs hero ???
        System.out.println(modifiers);
        hero.updateStats(modifiers.getOrDefault("health_point", 0), modifiers.getOrDefault("attack_point", 0), modifiers.getOrDefault("defense_point", 0), modifiers.getOrDefault("magic_point", 0), modifiers.getOrDefault("speed", 0));
        hero.updateExp(modifiers.getOrDefault("exp", 0));
        heroDao.save(hero);
        return story;
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
