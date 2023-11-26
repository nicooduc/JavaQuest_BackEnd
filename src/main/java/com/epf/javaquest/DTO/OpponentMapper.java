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
                .origin_id(dto.getOrigin_id())
                .type(dto.getType())
                .name(dto.getName())
                .image(dto.getImage())
                .healthPoint(dto.getHealthPoint())
                .attackPoint(dto.getAttackPoint())
                .defensePoint(dto.getDefensePoint())
                .magicPoint(dto.getMagicPoint())
                .speed(dto.getSpeed())
                .build();
    }

    public static OpponentDto toDto (Opponent opponent){
        return OpponentDto.builder()
                .origin_id(opponent.getOrigin_id())
                .type(opponent.getType())
                .name(opponent.getName())
                .image(opponent.getImage())
                .healthPoint(opponent.getHealthPoint())
                .attackPoint(opponent.getAttackPoint())
                .defensePoint(opponent.getDefensePoint())
                .magicPoint(opponent.getMagicPoint())
                .speed((opponent.getSpeed()))
                .build();
    }
}
