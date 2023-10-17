package com.epf.javaquest.controllers;

import com.epf.javaquest.DTO.OpponentDto;
import com.epf.javaquest.models.Opponent;
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

    // TODO - Exemple des requetes possibles - supprimer la majorité

    @GetMapping("")
//    public List<Opponent> listStudents(@RequestParam(required = false) Integer majorId, @RequestParam(required = false) Integer courseId) {
//        if (majorId != null && courseId !=null) {
//            return opponentService.searchByMajorAndCourse(majorId, courseId);
//        }
//        return opponentService.findAll();
//    }

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
