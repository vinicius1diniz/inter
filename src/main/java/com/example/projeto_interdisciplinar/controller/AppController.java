package com.example.projeto_interdisciplinar.controller;

import com.example.projeto_interdisciplinar.entity.Aula;
import com.example.projeto_interdisciplinar.entity.Curso;
import com.example.projeto_interdisciplinar.service.CourseService;
import com.example.projeto_interdisciplinar.service.LessonService;
import com.example.projeto_interdisciplinar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/app")
public class AppController {
    private UserService userService;
    private CourseService courseService;
    private LessonService lessonService;
    @Autowired
    public AppController(UserService userService, CourseService courseService, LessonService lessonService) {
        this.userService = userService;
        this.courseService = courseService;
        this.lessonService = lessonService;
    }
    @GetMapping("/ranking")
    public ResponseEntity ranking(){
        return userService.getRanking();
    }
    @GetMapping("/home")
    public ResponseEntity home(@RequestParam int id){
        Curso response =  courseService.showHome(id);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/cursosbytema")
    public ResponseEntity cursosByTema(@RequestParam String tema){
        List<Curso> response = courseService.findCoursesByTheme(tema);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/all")
    public ResponseEntity allCourses(){
        List<Curso> response = courseService.findAllCourses();
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/suggestedcourse")
    public ResponseEntity suggestedCourses(){
        List<Curso> response = courseService.findSuggestedCourses();
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/lessons")
    public ResponseEntity allLessonsByCourse(@RequestParam int id){
        List<Aula> response = lessonService.getAulasByCurso(id);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/currentclass")
    public ResponseEntity currentClass(@RequestParam int user_id, @RequestParam int course_id){
        int aula = courseService.AulaAtual(user_id, course_id);
        return ResponseEntity.ok().body(aula);
    }
}
