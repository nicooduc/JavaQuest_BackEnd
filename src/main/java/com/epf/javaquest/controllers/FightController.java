package com.epf.javaquest.controllers;

import com.epf.javaquest.models.Opponent;
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

    //TODO startCombat doit pouvoir prendre l'id du monstre
    @GetMapping("/startCombat")
    public List<Opponent> startCombat() {
        return opponentService.startCombat();
    }

    @GetMapping("/turn/{action}")
    public List<Opponent> turn(@PathVariable String action) {
        return fightService.turn(action);
    }

    @GetMapping("/check{type}Status")
    public boolean checkStatus(@PathVariable String type) {
        return opponentService.checkStatus(type);
    }

    @GetMapping("/endFight")
    public Integer endFight() {
        return fightService.endFight();
    }




    // TODO touts les objets sont sensé être des DTO ici

    // TODO supprimer les lignes suivantes après s'en être inspiré

    @GetMapping("")
    public List<Opponent> listOpponents() {
        return opponentService.findAll();
    }

    @GetMapping("/{id}")
    public Opponent getOpponentById(@PathVariable Long id) {
        return opponentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOpponent(@PathVariable Long id) {
        opponentService.deleteById(id);
    }

    @PostMapping("")
    public void addOpponent(@RequestBody Opponent opponent) {
        opponentService.addOpponent(opponent);
    }

    @PostMapping("/{id}")
    public void updateOpponent(@RequestBody Opponent opponent, @PathVariable Long id) {
        opponentService.updateOpponent(opponent, id);
    }
}
