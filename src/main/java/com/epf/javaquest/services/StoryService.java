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

/**
 * Service gérant les opérations liées aux histoires (story) du jeu.
 */
@Component
@RequiredArgsConstructor
public class StoryService {
    private final StoryDao storyDao;
    private final HeroDao heroDao;

    /**
     * Démarre une nouvelle histoire en récupérant la première étape à partir de son identifiant.
     *
     * @param storyNextID L'identifiant de l'étape suivante dans l'histoire.
     * @return L'objet DTO représentant l'étape de l'histoire.
     */
    public StoryDto startStory(int storyNextID) {
        Story story = storyDao.findByDescriptionID(storyNextID);
        return StoryMapper.toDto(story);
    }

    /**
     * Effectue un choix dans l'histoire, met à jour les statistiques du héros en fonction des effets, et retourne la prochaine étape.
     *
     * @param choice L'identifiant de l'étape suivante dans l'histoire en fonction du choix effectué.
     * @return L'objet DTO représentant la prochaine étape de l'histoire.
     */
    public StoryDto storyChoice(int choice) {
        Story story = storyDao.findByDescriptionID(choice);
        Map<String, Integer> modifiers = (story.getEffects() != null) ? parseModifiers(story.getEffects()) : new HashMap<>();
        Hero hero = heroDao.findAll().get(0); // update 0 if multiple heroes available
        hero.updateStats(modifiers.getOrDefault("health_point", 0), modifiers.getOrDefault("attack_point", 0), modifiers.getOrDefault("defense_point", 0), modifiers.getOrDefault("magic_point", 0), modifiers.getOrDefault("speed", 0));
        hero.updateExp(modifiers.getOrDefault("exp", 0));
        heroDao.save(hero);
        return StoryMapper.toDto(story);
    }

    /**
     * Parse les modificateurs d'effets à partir d'une chaîne de caractères.
     *
     * @param inputModifiers Chaîne de caractères représentant les modificateurs d'effets sous forme de paires clé-valeur séparées par des points-virgules.
     * @return Une map des modificateurs d'effets.
     */
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
