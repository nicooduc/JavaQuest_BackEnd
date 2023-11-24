package com.epf.javaquest.DTO;

import com.epf.javaquest.models.Story;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Builder
@Service
public class StoryMapper {
    public static Story fromDto(StoryDto dto) {
        return Story.builder()
                .descriptionID(dto.getDescriptionID())
                .textDescription(dto.getTextDescription())
                .option1(dto.getOption1())
                .redirection1(dto.getRedirection1())
                .option2(dto.getOption2())
                .redirection2(dto.getRedirection2())
                .option3(dto.getOption3())
                .redirection3(dto.getRedirection3())
                .option4(dto.getOption4())
                .redirection4(dto.getRedirection4())
                .build();
    }

    public static StoryDto toDto (Story story){
        return StoryDto.builder()
                .descriptionID(story.getDescriptionID())
                .textDescription(story.getTextDescription())
                .option1(story.getOption1())
                .redirection1(story.getRedirection1())
                .option2(story.getOption2())
                .redirection2(story.getRedirection2())
                .option3(story.getOption3())
                .redirection3(story.getRedirection3())
                .option4(story.getOption4())
                .redirection4(story.getRedirection4())
                .build();
    }
}
