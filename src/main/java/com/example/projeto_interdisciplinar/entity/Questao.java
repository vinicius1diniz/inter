package com.example.projeto_interdisciplinar.entity;

import com.example.projeto_interdisciplinar.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String enunciado;
    private String alternativa_certa;
    private String alternativa_errada1;
    private String alternativa_errada2;
    private String alternativa_errada3;
    private int fk_aula_id;
}
