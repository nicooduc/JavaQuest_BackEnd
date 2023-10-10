package com.epf.javaquest.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name = "hero")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "health_point", nullable = false)
    private int healthPoint;

    @Column(name = "attack_point", nullable = false)
    private int attackPoint;

    @Column(name = "defense_point", nullable = false)
    private int defensePoint;

    @Column(name = "magic_point", nullable = false)
    private int magicPoint;

    @Column(name = "exp", nullable = false, columnDefinition = "int default 0")
    private int exp;

    public Hero(String name, Object img, int level, int hp, int atk, int def, int mag, int exp) {
    }

    public Hero() {

    }
}
