package com.denireas.turion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String mainPage() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String now = LocalDateTime.now().format(formatter);
        System.out.println("\nСейчас: " + now);
        return "MainPage";
    }

    @GetMapping("/second")
    public String secondPage() {
        return "SecondPage";
    }
}
