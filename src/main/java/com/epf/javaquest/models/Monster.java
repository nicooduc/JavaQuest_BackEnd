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
@Table(name = "monsters")
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image")
    private String image;

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

}
