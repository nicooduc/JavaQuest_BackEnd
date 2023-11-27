package com.epf.javaquest.DTO;

import com.epf.javaquest.models.Opponent;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Service
public class OpponentMapper {
    public static List<OpponentDto> toDtoList(List<Opponent> opponents) {
        return opponents.stream()
                .map(opponent -> OpponentDto.builder()
                        .type(opponent.getType())
                        .name(opponent.getName())
                        .image(opponent.getImage())
                        .healthPoint(opponent.getHealthPoint())
                        .attackPoint(opponent.getAttackPoint())
                        .defensePoint(opponent.getDefensePoint())
                        .magicPoint(opponent.getMagicPoint())
                        .speed(opponent.getSpeed())
                        .build())
                .collect(Collectors.toList());
    }

}
