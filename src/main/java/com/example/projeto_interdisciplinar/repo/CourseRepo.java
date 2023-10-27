package com.example.projeto_interdisciplinar.repo;

import com.example.projeto_interdisciplinar.dto.RankingDTO;
import com.example.projeto_interdisciplinar.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepo extends JpaRepository<Curso,Integer> {
    @Query("SELECT u FROM Curso u ORDER BY RANDOM() LIMIT 2")
    List<Curso> CursosSugeridos();
    @Query("SELECT u FROM Curso u WHERE u.tema = :tema")
    List<Curso> CursosPorTema(String tema);
    @Query("SELECT u.foto_curso FROM Curso u WHERE u.id = :id")
    String getCourseUrl(int id);
    @Query("SELECT u.nome FROM Curso u WHERE u.id = :id")
    String getCourseName(int id);
}
