package com.epf.javaquest.models;

import io.swagger.v3.oas.models.headers.Header;
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
@Table(name = "monsters")
public class Monster {
    private static final int DEFENSE_MODIFIER = 2;
    private static final int HEALTH_MODIFIER = 2;

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

    @Column(name = "speed_min")
    private int speedMin;

    @Column(name = "speed_max")
    private int speedMax;


    @Transient
    private int healthPoint;
    @Transient
    private int attackPoint;
    @Transient
    private int defensePoint;
    @Transient
    private int magicPoint;
    @Transient
    private int speedPoint;

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
        this.speedMin = monster.getSpeedMin();
        this.speedMax = monster.getSpeedMax();
        this.healthPoint = monster.getHealthPoint();
        this.attackPoint = monster.getAttackPoint();
        this.defensePoint = monster.getDefensePoint();
        this.magicPoint = monster.getMagicPoint();
        this.speedPoint = monster.getSpeedPoint();
    }

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
    public void regenHealthMag(){
        healthPoint += HEALTH_MODIFIER;
    }

}
