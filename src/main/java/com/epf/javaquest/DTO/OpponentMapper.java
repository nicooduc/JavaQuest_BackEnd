package com.epf.javaquest.DTO;

import com.epf.javaquest.models.Opponent;
import lombok.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Builder
@Service
public class OpponentMapper {
    public static Opponent fromDto(OpponentDto dto) {
        return Opponent.builder()
                .type(dto.getType())
                .healthPoint(dto.getHealthPoint())
                .attackPoint(dto.getAttackPoint())
                .defensePoint(dto.getDefensePoint())
                .magicPoint(dto.getMagicPoint())
                .speed(dto.getSpeed())
                .build();
    }

    public static OpponentDto toDto (Opponent opponent){
        return OpponentDto.builder()
                .type(opponent.getType())
                .healthPoint(opponent.getHealthPoint())
                .attackPoint(opponent.getAttackPoint())
                .defensePoint(opponent.getDefensePoint())
                .magicPoint(opponent.getMagicPoint())
                .speed((opponent.getSpeed()))
                .build();
    }
}
