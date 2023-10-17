package com.example.projeto_interdisciplinar.entity;

import com.example.projeto_interdisciplinar.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UsuarioCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fk_usuario_id;
    private int fk_curso_id;
    private int aula_atual;
    private Timestamp ultimo_acesso;
}
