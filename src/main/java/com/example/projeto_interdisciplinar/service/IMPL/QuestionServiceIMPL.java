package com.example.projeto_interdisciplinar.service.IMPL;

import com.example.projeto_interdisciplinar.entity.Aula;
import com.example.projeto_interdisciplinar.entity.Curso;
import com.example.projeto_interdisciplinar.entity.Questao;
import com.example.projeto_interdisciplinar.repo.*;
import com.example.projeto_interdisciplinar.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceIMPL implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private LessonRepo lessonRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserCourseRepo userCourseRepo;

    @Override
    public Questao getExerciseByClass(int curso_id, String email) {
        try{
            int user_id = userRepo.findIdByEmail(email);
            int num_aula_atual = userCourseRepo.getAulaAtual(user_id, curso_id);
            List<Aula> aulas = lessonRepo.AllLessons(curso_id);
            Aula aula_atual = aulas.get(num_aula_atual-1);
            int id_aula_atual = aula_atual.getId();
            return questionRepo.findQuestionByAula(id_aula_atual);

        } catch (Exception e){
            return null;
        }
    }
}
