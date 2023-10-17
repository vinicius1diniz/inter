package com.example.projeto_interdisciplinar.service.IMPL;

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
    public Map showHome(int id){
        UsuarioCurso userCouser = findLastCourse(id);
        Curso ultimoCurso = courseRepo.findById(userCouser.getId()).orElse(null);
        Map<Integer, Curso> response = new HashMap<>();
        List<Curso> sugeridos = findSuggestedCourses();
        response.put(0, ultimoCurso);
        response.put(1, sugeridos.get(0));
        response.put(2, sugeridos.get(1));
        return response;
    }
    }
