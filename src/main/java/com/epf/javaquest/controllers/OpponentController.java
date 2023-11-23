package com.epf.javaquest.controllers;

import com.epf.javaquest.DTO.OpponentDto;
import com.epf.javaquest.models.Opponent;
import com.epf.javaquest.services.FightService;
import com.epf.javaquest.services.OpponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("opponent")
@RestController
@RequiredArgsConstructor
public class OpponentController {
    private final OpponentService opponentService;

    @GetMapping("/startCombat")
    public List<Opponent> startCombat() {
        return opponentService.startCombat();
    }

    @GetMapping("/attack")
    public List<Opponent> attack() {
        return opponentService.heroAttack();
    }
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
    public void addOpponent(@RequestBody OpponentDto opponentDto) {
        opponentService.addOpponent(opponentDto);
    }

    @PostMapping("/{id}")
    public void updateOpponent(@RequestBody OpponentDto opponentDto, @PathVariable Long id) {
        opponentService.updateOpponent(opponentDto, id);
    }
}
