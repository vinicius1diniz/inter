package com.example.projeto_interdisciplinar.repo;

import com.example.projeto_interdisciplinar.entity.Aula;
import com.example.projeto_interdisciplinar.entity.UsuarioCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonRepo extends JpaRepository<UsuarioCurso,Integer> {
    @Query("SELECT u FROM Aula u WHERE u.fk_curso_id = :id")
    List<Aula> AllLessons(int id);
}
