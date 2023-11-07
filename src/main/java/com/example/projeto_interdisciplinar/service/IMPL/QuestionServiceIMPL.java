package com.example.projeto_interdisciplinar.service.IMPL;

import com.example.projeto_interdisciplinar.entity.Aula;
import com.example.projeto_interdisciplinar.entity.Curso;
import com.example.projeto_interdisciplinar.entity.Questao;
import com.example.projeto_interdisciplinar.repo.CourseRepo;
import com.example.projeto_interdisciplinar.repo.LessonRepo;
import com.example.projeto_interdisciplinar.repo.QuestionRepo;
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

    @Override
    public Questao getExerciseByClass(int tema_id, int id_aula_atual) {
        List<Aula> cursos = lessonRepo.AllLessons(tema_id);
        Aula aula_atual = cursos.get(id_aula_atual);
        return questionRepo.findQuestionByAula(aula_atual.getId());
    }
}
