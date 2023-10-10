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
@Table(name = "hero")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "level")
    private int level;

    @Column(name = "health_point")
    private int healthPoint;

    @Column(name = "attack_point")
    private int attackPoint;

    @Column(name = "defense_point")
    private int defensePoint;

    @Column(name = "magic_point")
    private int magicPoint;

    @Column(name = "exp")
    private int exp;

}
