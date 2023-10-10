package com.epf.javaquest.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "monsters" )
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "hp_mult_min", nullable = false)
    private Integer hpMultMin;

    @Column(name = "hp_mult_max", nullable = false)
    private Integer hpMultMax;

    @Column(name = "atk_mult_min", nullable = false)
    private Integer atkMultMin;

    @Column(name = "atk_mult_max", nullable = false)
    private Integer atkMultMax;

    @Column(name = "def_mult_min", nullable = false)
    private Integer defMultMin;

    @Column(name = "def_mult_max", nullable = false)
    private Integer defMultMax;

    @Column(name = "mag_mult_min", nullable = false)
    private Integer magMultMin;

    @Column(name = "mag_mult_max", nullable = false)
    private Integer magMultMax;

}
