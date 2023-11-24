package com.epf.javaquest.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(name = "descriptionID", nullable = false)
    private int descriptionID;

    @Column(name = "text_description", nullable = false)
    private String textDescription;

    @Column(name = "localisation", nullable = false)
    private String localisation;

    @Column(name = "image")
    private String image;

    @Column(name = "option1", nullable = false)
    private String option1;

    @Column(name = "redirection1", nullable = false)
    private int redirection1;

    @Column(name = "option2", nullable = false)
    private String option2;

    @Column(name = "redirection2", nullable = false)
    private int redirection2;

    @Column(name = "option3", nullable = false)
    private String option3;

    @Column(name = "redirection3", nullable = false)
    private int redirection3;

    @Column(name = "option4", nullable = false)
    private String option4;

    @Column(name = "redirection4", nullable = false)
    private int redirection4;

    @Column(name = "effects")
    private String effects;

}
