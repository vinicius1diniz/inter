package com.example.projeto_interdisciplinar.service;

import com.example.projeto_interdisciplinar.entity.Aula;

import java.util.List;

public interface LessonService {
    List<Aula> getAulasByCurso(int id);
}
