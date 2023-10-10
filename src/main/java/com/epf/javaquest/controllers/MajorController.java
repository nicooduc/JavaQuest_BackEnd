package com.epf.javaquest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("majors")
@RestController
@RequiredArgsConstructor
public class MajorController {
//    private final MajorService majorService;
//
//    @GetMapping("")
//    public List<Major> findAll() {
//        return majorService.findAll();
//    }
//
//    @GetMapping("/{id}/students")
//    public List<Student> getStudentsOfMajor(@PathVariable Long id) {
//        return majorService.getStudentsOfMajor(id);
//    }
}
