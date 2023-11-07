package com.example.projeto_interdisciplinar.service;

import com.example.projeto_interdisciplinar.entity.Questao;

public interface QuestionService {
    Questao getExerciseByClass(int tema_id, int id_aula_atual);

}
