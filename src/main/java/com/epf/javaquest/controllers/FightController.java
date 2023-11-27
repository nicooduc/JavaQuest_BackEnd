package com.epf.javaquest.controllers;

import com.epf.javaquest.DTO.OpponentDto;
import com.epf.javaquest.services.FightService;
import com.epf.javaquest.services.OpponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("fight")
@RestController
@RequiredArgsConstructor
public class FightController {
    private final OpponentService opponentService;
    private final FightService fightService;

    // Démarre un combat avec un monstre spécifique
    @GetMapping("/startCombat/{idMonster}")
    public List<OpponentDto> startCombat(@PathVariable int idMonster) {
        return opponentService.startCombat(idMonster);
    }

    // Effectue une action pendant le combat (Attaque, Défense, Magie, etc.)
    @GetMapping("/turn/{action}")
    public List<OpponentDto> turn(@PathVariable String action) {
        return fightService.turn(action);
    }

    // Vérifie l'état de vie d'un type d'opposant (Hero ou Monster)
    @GetMapping("/check{type}Status")
    public boolean checkStatus(@PathVariable String type) {
        return opponentService.checkStatus(type);
    }

    // Termine le combat, indiquant le succès ou l'échec, et retourne les points d'expérience gagnés
    @GetMapping("/endFight/{success}")
    public Integer endFight(@PathVariable boolean success) {
        return fightService.endFight(success);
    }
}
