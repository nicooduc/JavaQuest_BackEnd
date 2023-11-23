package com.epf.javaquest.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OpponentDto {
    private String type;
    private String name;
    private int healthPoint;
    private int attackPoint;
    private int defensePoint;
    private int magicPoint;
    private int speed;
}
