package com.example.projeto_interdisciplinar.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDTO {
    private Date data_nascimento;
    private String senha;
    private String nome_usuario;
    private String nome_real;
    private String email;
    private String foto_perfil;
}
