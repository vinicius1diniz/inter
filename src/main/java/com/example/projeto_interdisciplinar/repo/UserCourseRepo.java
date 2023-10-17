package com.example.projeto_interdisciplinar.repo;

import com.example.projeto_interdisciplinar.entity.Curso;
import com.example.projeto_interdisciplinar.entity.UsuarioCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserCourseRepo extends JpaRepository<UsuarioCurso,Integer> {
    @Query("SELECT u FROM UsuarioCurso u WHERE u.fk_usuario_id = :id ORDER BY u.ultimo_acesso LIMIT 1")
    UsuarioCurso UltimoCursoAcessado(int id);
}

