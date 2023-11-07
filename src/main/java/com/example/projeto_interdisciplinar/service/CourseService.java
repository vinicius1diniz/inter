package com.example.projeto_interdisciplinar.service;
import com.example.projeto_interdisciplinar.entity.Curso;
import com.example.projeto_interdisciplinar.entity.UsuarioCurso;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CourseService {
    List<Curso> findAllCourses();
    List<Curso> findSuggestedCourses();
    UsuarioCurso findLastCourse(int usuario_id);
    Curso showLastCourse(int id);
    List<Curso> findCoursesByTheme(String tema);

    HashMap AulaAtual(String email, int course_id);
    HashMap<String, Object> showHome(String email);
}
