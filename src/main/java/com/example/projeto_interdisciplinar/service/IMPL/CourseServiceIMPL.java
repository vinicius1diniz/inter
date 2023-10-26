package com.example.projeto_interdisciplinar.service.IMPL;
import com.example.projeto_interdisciplinar.TemasCurso;
import com.example.projeto_interdisciplinar.entity.Curso;
import com.example.projeto_interdisciplinar.entity.UsuarioCurso;
import com.example.projeto_interdisciplinar.repo.CourseRepo;
import com.example.projeto_interdisciplinar.repo.UserCourseRepo;
import com.example.projeto_interdisciplinar.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CourseServiceIMPL implements CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private UserCourseRepo userCourseRepo;

    public List<Curso> findAllCourses(){
        return courseRepo.findAll();
    }
    public List<Curso> findSuggestedCourses(){
        return courseRepo.CursosSugeridos();
    }
    public UsuarioCurso findLastCourse(int id){
        return userCourseRepo.UltimoCursoAcessado(id);
    }
    public int AulaAtual(int user_id, int course_id){
        return userCourseRepo.getAulaAtual(user_id, course_id);
    }
    public Curso showHome(int id){
        UsuarioCurso userCouser = findLastCourse(id);
        if (userCouser != null){
            return courseRepo.findById(userCouser.getId()).orElse(null);
        } else{
            return null;
        }
    }
    public List<Curso> findCoursesByTheme(String tema){
        try {
            TemasCurso temaEnum = TemasCurso.valueOf(tema);
            return courseRepo.CursosPorTema(String.valueOf(temaEnum));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
    }