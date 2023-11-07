package com.example.projeto_interdisciplinar.controller;

import com.example.projeto_interdisciplinar.entity.Aula;
import com.example.projeto_interdisciplinar.entity.Curso;
import com.example.projeto_interdisciplinar.entity.Questao;
import com.example.projeto_interdisciplinar.service.CourseService;
import com.example.projeto_interdisciplinar.service.LessonService;
import com.example.projeto_interdisciplinar.service.QuestionService;
import com.example.projeto_interdisciplinar.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/app")
public class AppController {
    private UserService userService;
    private CourseService courseService;
    private LessonService lessonService;
    private QuestionService questionService;
    @Autowired
    public AppController(UserService userService, CourseService courseService, LessonService lessonService, QuestionService questionService) {
        this.userService = userService;
        this.courseService = courseService;
        this.lessonService = lessonService;
        this.questionService = questionService;
    }
    @GetMapping("/ranking")
    public ResponseEntity ranking(){
        return userService.getRanking();
    }
    @GetMapping("/cursosbytema")
    public ResponseEntity cursosByTema(@RequestParam String tema){
        List<Curso> response = courseService.findCoursesByTheme(tema);
        if(response != null){
            return ResponseEntity.ok().body(response);
        } else{
            return ResponseEntity.badRequest().body("Curso inválido ou sem aulas disponíveis");
        }
    }
    @GetMapping("/all")
    public ResponseEntity allCourses(){
        List<Curso> response = courseService.findAllCourses();
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/suggestedcourse")
    public ResponseEntity suggestedCourses(String email){
        HashMap<String, Curso> response = courseService.showHome(email);
        if(response != null){
            return ResponseEntity.ok().body(response);
        } else{
            return ResponseEntity.badRequest().body("Erro ao gerar página de home");
        }
    }
    @GetMapping("/lessons")
    public ResponseEntity allLessonsByCourse(@RequestParam int id){
        List<Aula> response = lessonService.getAulasByCurso(id);
        if(response != null){
            return ResponseEntity.ok().body(response);
        } else{
            return ResponseEntity.badRequest().body("Curso inválido");
        }
    }
    @GetMapping("/currentclass")
    public ResponseEntity currentClass(@RequestParam String email, @RequestParam int course_id){
        HashMap response = courseService.AulaAtual(email, course_id);
        if (response != null){
            return ResponseEntity.ok().body(response);
        } else{
            return ResponseEntity.badRequest().body("Email inválido");
        }
    }

    @GetMapping("/exercise")
    public ResponseEntity exercise(@RequestParam int tema_id, @RequestParam int id_aula_atual){
        Questao questao = questionService.getExerciseByClass(tema_id, id_aula_atual);
        return ResponseEntity.ok().body(questao);
    }
    //
}
