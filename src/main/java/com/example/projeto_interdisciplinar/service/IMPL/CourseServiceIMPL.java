package com.example.projeto_interdisciplinar.service.IMPL;
import com.example.projeto_interdisciplinar.TemasCurso;
import com.example.projeto_interdisciplinar.entity.Curso;
import com.example.projeto_interdisciplinar.entity.UsuarioCurso;
import com.example.projeto_interdisciplinar.repo.CourseRepo;
import com.example.projeto_interdisciplinar.repo.UserCourseRepo;
import com.example.projeto_interdisciplinar.repo.UserRepo;
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
    @Autowired
    private UserRepo userRepo;

    public List<Curso> findAllCourses(){
        return courseRepo.findAll();
    }
    public UsuarioCurso findLastCourse(int usuario_id){
        try{
            return userCourseRepo.UltimoCursoAcessado(usuario_id);
        } catch (Exception e){
            return null;
        }
    }
    public HashMap<String, Object> AulaAtual(String email, int course_id){
        try{
            int user_id = userRepo.findIdByEmail(email);
            int aulaAtual;
            try{
                aulaAtual = userCourseRepo.getAulaAtual(user_id, course_id);
            } catch (Exception e){
                UsuarioCurso novoCurso = new UsuarioCurso(user_id, course_id);
                userCourseRepo.save(novoCurso);
                aulaAtual = userCourseRepo.getAulaAtual(user_id, course_id);
            }
            String imagem = courseRepo.getCourseUrl(course_id);
            String curso = courseRepo.getCourseName(course_id);
            HashMap<String, Object> response = new HashMap<>();
            response.put("imagem", imagem);
            response.put("nome_curso", curso);
            response.put("indice_aula", aulaAtual);
            return response;
        } catch (Exception e){
            return null;
        }
    }
    public List<Curso> findSuggestedCourses(){
        return courseRepo.CursosSugeridos();
    }
    public Curso showLastCourse(int id){
        try{
            UsuarioCurso userCouser = findLastCourse(id);
            if (userCouser != null){
                return courseRepo.findById(userCouser.getFk_curso_id()).orElse(null);
            } else{
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }
    public HashMap<String, Curso> showHome(String email){
        try{
            int user_id = userRepo.findIdByEmail(email);
            Curso lastCourse = showLastCourse(user_id);
            List<Curso> suggestedCourse = findSuggestedCourses();
            HashMap<String, Curso> response = new HashMap<>();
            response.put("ultimo", lastCourse);
            response.put("sugerido1", suggestedCourse.get(0));
            response.put("sugerido2", suggestedCourse.get(1));
            return response;
        } catch (Exception e){
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