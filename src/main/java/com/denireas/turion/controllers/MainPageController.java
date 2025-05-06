package com.denireas.turion.controllers;

import com.denireas.turion.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
public class MainPageController {

    private final StudentService studentService;

    @Autowired
    public MainPageController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String mainPage() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String now = LocalDateTime.now().format(formatter);
        log.info("\nСейчас: " + now);
        return "MainPage";
    }

    @GetMapping("/second")
    public String secondPage() {
        return "SecondPage";
    }

    @GetMapping("/students")
    public String studentsList() {
        return studentService.getAllStudents().toString();
    }
}
