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
@Table(name = "opponent")
public class Opponent {
    private static final int DEFENSE_MODIFIER = 2;
    private static final int HEALTH_MODIFIER = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "health_point", nullable = false)
    private int healthPoint;

    @Column(name = "attack_point", nullable = false)
    private int attackPoint;

    @Column(name = "defense_point", nullable = false)
    private int defensePoint;

    @Column(name = "magic_point", nullable = false)
    private int magicPoint;

    @Column(name = "speed", nullable = false)
    private int speed;

    public void updateHealth(int hp_modifier) {
        healthPoint += hp_modifier;
    }

    public void updateAttack(int atk_modifier) {
        attackPoint += atk_modifier;
    }

    public void updateDefense(int def_modifier) {
        defensePoint += def_modifier;
    }

    public void updateMagic(int mag_modifier) {
        magicPoint += mag_modifier;
    }

    public void choiceDefense() {
        System.out.println("PASSAGE EN MODE DEFENSE DU MONSTRE (yuuuuu-gi-ooooh)");
        defensePoint *= DEFENSE_MODIFIER;

    }

    public void resetDefense() {
        System.out.println("PLUS PASSAGE EN MODE DEFENSE DU MONSTRE (yuuuuu-gi-ooooh)");
        defensePoint /= DEFENSE_MODIFIER;
    }

    public void regenHealthMag() {
        healthPoint += HEALTH_MODIFIER;
    }

    public boolean isDead() {
        return healthPoint <= 0;
    }

}