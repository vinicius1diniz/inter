package com.example.projeto_interdisciplinar.service.IMPL;

import com.example.projeto_interdisciplinar.entity.Questao;
import com.example.projeto_interdisciplinar.repo.LessonRepo;
import com.example.projeto_interdisciplinar.repo.QuestionRepo;
import com.example.projeto_interdisciplinar.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceIMPL implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Questao getExerciseByClass(int id) {
        return questionRepo.findQuestionByAula(id);
    }
}
