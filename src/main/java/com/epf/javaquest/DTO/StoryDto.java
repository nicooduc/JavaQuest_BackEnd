package com.epf.javaquest.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StoryDto {
    private String textDescription;
    private String localisation;
    private String image;
    private String option1;
    private int redirection1;
    private String option2;
    private int redirection2;
    private String option3;
    private int redirection3;
    private String option4;
    private int redirection4;
    private Integer monsterID;
}
