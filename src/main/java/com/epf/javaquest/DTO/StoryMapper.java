package com.epf.javaquest.DTO;

import com.epf.javaquest.models.Story;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Builder
@Service
public class StoryMapper {
    public static StoryDto toDto (Story story){
        System.out.println("TODTO debut : " + story.getImage());
        StoryDto story2 =  StoryDto.builder()
                .textDescription(story.getTextDescription())
                .localisation(story.getLocalisation())
                .image(story.getImage())
                .option1(story.getOption1())
                .redirection1(story.getRedirection1())
                .option2(story.getOption2())
                .redirection2(story.getRedirection2())
                .option3(story.getOption3())
                .redirection3(story.getRedirection3())
                .option4(story.getOption4())
                .redirection4(story.getRedirection4())
                .monsterID(story.getMonsterID())
                .build();
        System.out.println("TODTO fin : " + story2.getImage());
        return story2;
    }
}
