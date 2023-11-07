package com.example.projeto_interdisciplinar.repo;

import com.example.projeto_interdisciplinar.dto.RankingDTO;
import com.example.projeto_interdisciplinar.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<Usuario,Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Usuario findByEmail(String email);
    @Query("SELECT u.id FROM Usuario u WHERE u.email = :email")
    int findIdByEmail(String email);
    @Query("SELECT new com.example.projeto_interdisciplinar.dto.RankingDTO(u.nome_usuario, u.pontos) FROM Usuario u  ORDER BY u.pontos DESC LIMIT 5")
    List<RankingDTO> WeeklyRanking();
}
