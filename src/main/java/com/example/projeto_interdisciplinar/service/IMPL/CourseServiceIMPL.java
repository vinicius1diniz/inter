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

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.*;

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

    public void setLastCourse(int course_id, String email){
        int user_id = userRepo.findIdByEmail(email);
        UsuarioCurso curso = userCourseRepo.CursoEmProgresso(course_id, user_id);
        curso.setUltimo_acesso(new Timestamp(System.currentTimeMillis()));
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
    public HashMap<String, Object> showHome(String email){
        try{
            int user_id = userRepo.findIdByEmail(email);
            HashMap<String, Object> ultimo = new HashMap<>();
            try{
                Curso lastCourse = showLastCourse(user_id);
                int course_id = lastCourse.getId();
                int indice = userCourseRepo.getAulaAtual(user_id, course_id);
                String imagem = courseRepo.getCourseUrl(course_id);
                String curso = courseRepo.getCourseName(course_id);
                ultimo.put("imagem", imagem);
                ultimo.put("nome_curso", curso);
                ultimo.put("indice_aula", indice);
            } catch (Exception e){
                ultimo = null;
            }
            List<Curso> suggestedCourse = findSuggestedCourses();
            HashMap<String, Object> response = new HashMap<>();
            response.put("ultimo", ultimo);
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