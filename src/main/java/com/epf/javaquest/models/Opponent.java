package com.epf.javaquest.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entité représentant un adversaire (héros ou monstre) dans le jeu.
 */
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

    @Column(name = "origin_id", nullable = false)
    private Long origin_id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image")
    private String image;

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

    /**
     * Met à jour les points de vie de l'adversaire.
     */
    public void updateHealth(int hp_modifier) {
        healthPoint += hp_modifier;
    }

    /**
     * Met à jour les points d'attaque de l'adversaire.
     */
    public void updateAttack(int atk_modifier) {
        attackPoint += atk_modifier;
    }

    /**
     * Met à jour les points de défense de l'adversaire.
     */
    public void updateDefense(int def_modifier) {
        defensePoint += def_modifier;
    }

    /**
     * Met à jour les points de magie de l'adversaire.
     */
    public void updateMagic(int mag_modifier) {
        magicPoint += mag_modifier;
    }

    /**
     * Active le mode défense de l'adversaire.
     */
    public void choiceDefense() {
        defensePoint *= DEFENSE_MODIFIER;
    }

    /**
     * Désactive le mode défense de l'adversaire.
     */
    public void resetDefense() {
        defensePoint /= DEFENSE_MODIFIER;
    }

    /**
     * Régénère les points de vie et de magie de l'adversaire.
     */
    public void regenHealthMag() {
        healthPoint += HEALTH_MODIFIER;
    }

    /**
     * Vérifie si l'adversaire est mort.
     */
    public boolean isDead() {
        return healthPoint <= 0;
    }
}
