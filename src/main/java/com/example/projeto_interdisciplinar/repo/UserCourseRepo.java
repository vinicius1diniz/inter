package com.example.projeto_interdisciplinar.repo;

import com.example.projeto_interdisciplinar.entity.Curso;
import com.example.projeto_interdisciplinar.entity.UsuarioCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserCourseRepo extends JpaRepository<UsuarioCurso,Integer> {
    @Query("SELECT u FROM UsuarioCurso u WHERE u.fk_usuario_id = :id ORDER BY u.ultimo_acesso DESC LIMIT 1")
    UsuarioCurso UltimoCursoAcessado(int id);
    @Query("SELECT u FROM UsuarioCurso u WHERE u.fk_curso_id = :curso_id and u.fk_usuario_id = :usuario_id")
    UsuarioCurso CursoEmProgresso(int curso_id, int usuario_id);
    @Query("SELECT u.aula_atual FROM UsuarioCurso u WHERE u.fk_usuario_id = :user_id AND u.fk_curso_id = :curso_id")
    int getAulaAtual(int user_id, int curso_id);
}

