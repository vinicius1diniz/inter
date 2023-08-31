package com.example.projeto_interdisciplinar.repo;

import com.example.projeto_interdisciplinar.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Usuario,Integer> {
}
