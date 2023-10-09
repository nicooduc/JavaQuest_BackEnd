package com.takima.backskeleton.models;

import jakarta.persistence.*;

@Entity
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

    @Column(name = "hp_mult_min")
    private Integer hpMultMin;

    @Column(name = "hp_mult_max")
    private Integer hpMultMax;

    @Column(name = "atk_mult_min")
    private Integer atkMultMin;

    @Column(name = "atk_mult_max")
    private Integer atkMultMax;

    @Column(name = "def_mult_min")
    private Integer defMultMin;

    @Column(name = "def_mult_max")
    private Integer defMultMax;

    @Column(name = "mag_mult_min")
    private Integer magMultMin;

    @Column(name = "mag_mult_max")
    private Integer magMultMax;

    @Column(name = "id_statistics")
    private Integer id_statistics;
}
