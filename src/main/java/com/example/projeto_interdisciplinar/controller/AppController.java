package com.example.projeto_interdisciplinar.controller;

import com.example.projeto_interdisciplinar.service.CourseService;
import com.example.projeto_interdisciplinar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/app")
public class AppController {
    private UserService userService;
    private CourseService courseService;
    @Autowired
    public AppController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }
    @GetMapping("/ranking")
    public ResponseEntity ranking(){
        return userService.getRanking();
    }
    @GetMapping("/home")
    public ResponseEntity home(@RequestParam int id){
        Map response =  courseService.showHome(id);
        return ResponseEntity.ok().body(response);
    }
}
