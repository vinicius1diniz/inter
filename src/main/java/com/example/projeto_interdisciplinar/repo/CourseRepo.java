package com.example.projeto_interdisciplinar.repo;

import com.example.projeto_interdisciplinar.dto.RankingDTO;
import com.example.projeto_interdisciplinar.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepo extends JpaRepository<Curso,Integer> {
    @Query("SELECT u FROM Curso u ORDER BY RANDOM() LIMIT 2")
    List<Curso> CursosSugeridos();
}

