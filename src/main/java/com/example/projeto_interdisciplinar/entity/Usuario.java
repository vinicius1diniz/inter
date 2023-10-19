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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date data_nascimento;
    private String senha;
    private int pontos = 0;
    private String nome_usuario;
    private String nome_real;
    private String email;
    private int fk_plano_id = 1;


    public Usuario(UserDTO user) {
        this.data_nascimento = user.getData_nascimento();
        this.senha = user.getSenha();
        this.nome_usuario = user.getNome_usuario();
        this.nome_real = user.getNome_real();
        this.email = user.getEmail();
    }

}
