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
    private final static int HEALTH_POINT_MULT = 8;
    private final static int ATTACK_POINT_MULT = 5;
    private final static int DEFENSE_POINT_MULT = 2;
    private final static int MAGIC_POINT_MULT = 2;
    private final static int LEVEL_UP_EXP_MULT = 100;
    private final static int LVL_INCR = 1;
    private static final int SPEED_MULT = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

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

    @Column(name = "exp", nullable = false)
    private int exp;

    @Column(name = "speed", nullable = false)
    private int speed;

    public static Hero createHero(String name, int level) {
        return Hero.builder()
                .name(name)
                .image(null)
                .level(level)
                .healthPoint(HEALTH_POINT_MULT * level)
                .attackPoint(ATTACK_POINT_MULT * level)
                .defensePoint(DEFENSE_POINT_MULT * level)
                .magicPoint(MAGIC_POINT_MULT * level)
                .exp(0)
                .speed(SPEED_MULT)
                .build();
    }

    public void updateStats(int hpModifier, int atkModifier, int defModifier, int magModifier, int speedModifier) {
        this.healthPoint += hpModifier;
        this.attackPoint += atkModifier;
        this.defensePoint += defModifier;
        this.magicPoint += magModifier;
        this.speed += speedModifier;
    }

    public void updateExp(int expModifier) {
        this.exp += expModifier;
        int expToLevelUp = this.level * LEVEL_UP_EXP_MULT;
        if (this.exp >= expToLevelUp) {
            this.exp -= expToLevelUp;
            this.levelUp();
        }
    }

    public void levelUp() {
        this.level += LVL_INCR;
        this.updateStats(HEALTH_POINT_MULT, ATTACK_POINT_MULT, DEFENSE_POINT_MULT, MAGIC_POINT_MULT, SPEED_MULT);
    }

}
