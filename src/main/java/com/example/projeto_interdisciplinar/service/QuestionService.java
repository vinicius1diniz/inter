package com.example.projeto_interdisciplinar.service;

import com.example.projeto_interdisciplinar.entity.Questao;

public interface QuestionService {
    Questao getExerciseByClass(int curso_id, String email);

}
