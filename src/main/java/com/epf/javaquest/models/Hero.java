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

    public Hero updateHealth(Hero hero, int hp_modifier) {
        hero.setHealthPoint(hero.getHealthPoint() + hp_modifier);
        return hero;
    }

    public Hero updateAttack(Hero hero, int atk_modifier){
        hero.setAttackPoint(hero.getAttackPoint() + atk_modifier);
        return hero;
    }

    public Hero updateDefense(Hero hero, int def_modifier){
        hero.setDefensePoint(hero.getDefensePoint() + def_modifier);
        return hero;
    }

    public Hero updateMagic(Hero hero,int mag_modifier){
        hero.setMagicPoint(hero.getMagicPoint() + mag_modifier);
        return hero;
    }

}
