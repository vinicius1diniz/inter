package com.example.projeto_interdisciplinar.repo;

import com.example.projeto_interdisciplinar.entity.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepo extends JpaRepository<Questao,Integer> {
    @Query("SELECT u FROM Questao u WHERE u.fk_aula_id = :id")
    Questao findQuestionByAula(int id);
}
