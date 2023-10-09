package com.takima.backskeleton.models;

import jakarta.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "health_point")
    private Integer healthPoint;

    @Column(name = "attack_point")
    private Integer attackPoint;

    @Column(name = "defense_point")
    private Integer defensePoint;

    @Column(name = "magic_point")
    private Integer magicPoint;
}
