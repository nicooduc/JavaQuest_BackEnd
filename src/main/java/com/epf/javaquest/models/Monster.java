package com.epf.javaquest.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "monsters" )
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "hp_min")
    private Integer hpMin;

    @Column(name = "hp_max")
    private Integer hpMax;

    @Column(name = "atk_min")
    private Integer atkMin;

    @Column(name = "atk_max")
    private Integer atkMax;

    @Column(name = "def_min")
    private Integer defMin;

    @Column(name = "def_max")
    private Integer defMax;

    @Column(name = "mag_min")
    private Integer magMin;

    @Column(name = "mag_max")
    private Integer magMax;

    @Column(name = "xp_drop", nullable = false)
    private Integer xpDrop;

    @Transient
    private int healthPoint;
    @Transient
    private int attackPoint;
    @Transient
    private int defensePoint;
    @Transient
    private int magicPoint;

    public Monster(Monster monster) {
        this.id = monster.getId();
        this.name = monster.getName();
        this.image = monster.getImage();
        this.hpMin = monster.getHpMin();
        this.hpMax = monster.getHpMax();
        this.atkMin = monster.getAtkMin();
        this.atkMax = monster.getAtkMax();
        this.defMin = monster.getDefMin();
        this.defMax = monster.getDefMax();
        this.magMin = monster.getMagMin();
        this.magMax = monster.getMagMax();
        this.xpDrop = monster.getXpDrop();
        this.healthPoint = monster.getHealthPoint();
        this.attackPoint = monster.getAttackPoint();
        this.defensePoint = monster.getDefensePoint();
        this.magicPoint = monster.getMagicPoint();
    }

    public Monster updateHealth(Monster monster, int hp_modifier) {
        monster.setHealthPoint(monster.getHealthPoint() + hp_modifier);
        return monster;
    }

    public Monster updateAttack(Monster monster, int atk_modifier){
        monster.setAttackPoint(monster.getAttackPoint() + atk_modifier);
        return monster;
    }

    public Monster updateDefense(Monster monster, int def_modifier){
        monster.setDefensePoint(monster.getDefensePoint() + def_modifier);
        return monster;
    }

    public Monster updateMagic(Monster monster,int mag_modifier){
        monster.setMagicPoint(monster.getMagicPoint() + mag_modifier);
        return monster;
    }

}
