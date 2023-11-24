package com.epf.javaquest.services;

import com.epf.javaquest.DAO.StoryDao;
import com.epf.javaquest.models.Story;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoryService {
    private final StoryDao storyDao;

    public Story startStory() {
        System.out.println(storyDao.findByDescriptionID(1));
        return storyDao.findByDescriptionID(1);
    }

    public Story storyChoice(int choice) {
        System.out.println(storyDao.findByDescriptionID(choice));
        return storyDao.findByDescriptionID(choice);
    }


}
