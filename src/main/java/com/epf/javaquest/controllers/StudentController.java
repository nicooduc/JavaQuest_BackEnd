package com.epf.javaquest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("students")
@RestController
@RequiredArgsConstructor
public class StudentController {
//    private final StudentService studentService;
//    @GetMapping("")
//    public List<Student> listStudents(@RequestParam(required = false) Integer majorId, @RequestParam(required = false) Integer courseId) {
//        if (majorId != null && courseId !=null) {
//            return studentService.searchByMajorAndCourse(majorId, courseId);
//        }
//        return studentService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable Long id) {
//        return studentService.getById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteStudent(@PathVariable Long id) {
//        studentService.deleteById(id);
//    }
//
//    @PostMapping("")
//    public void addStudent(@RequestBody StudentDto studentDto) {
//        studentService.addStudent(studentDto);
//    }
//
//    @PostMapping("/{id}")
//    public void updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long id) {
//        studentService.updateStudent(studentDto, id);
//    }
}
