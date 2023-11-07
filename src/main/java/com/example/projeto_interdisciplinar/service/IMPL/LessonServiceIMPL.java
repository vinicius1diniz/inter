package com.example.projeto_interdisciplinar.service.IMPL;

import com.example.projeto_interdisciplinar.entity.Aula;
import com.example.projeto_interdisciplinar.repo.CourseRepo;
import com.example.projeto_interdisciplinar.repo.LessonRepo;
import com.example.projeto_interdisciplinar.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceIMPL implements LessonService {
    @Autowired
    private LessonRepo lessonRepo;

    public List<Aula> getAulasByCurso(int id){
        try{
            return lessonRepo.AllLessons(id);
        } catch (Exception e){
            return null;
        }
    }
}
