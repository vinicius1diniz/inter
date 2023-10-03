package com.example.projeto_interdisciplinar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date data_nascimento;
    private String senha;
    private int pontos;
    private String nome_usuario;
    private String nome_real;
    private String email;

    private int fk_plano_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getNome_real() {
        return nome_real;
    }

    public void setNome_real(String nome_real) {
        this.nome_real = nome_real;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFk_plano_id() {
        return fk_plano_id;
    }

    public void setFk_plano_id(int fk_plano_id) {
        this.fk_plano_id = fk_plano_id;
    }


    public Usuario(Date data_nascimento, String senha, int pontos, String nome_usuario, String nome_real, String email, int fk_plano_id) {
        this.data_nascimento = data_nascimento;
        this.senha = senha;
        this.pontos = pontos;
        this.nome_usuario = nome_usuario;
        this.nome_real = nome_real;
        this.email = email;
        this.fk_plano_id = fk_plano_id;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", data_nascimento=" + data_nascimento +
                ", senha='" + senha + '\'' +
                ", pontos=" + pontos +
                ", nome_usuario='" + nome_usuario + '\'' +
                ", nome_real='" + nome_real + '\'' +
                ", email='" + email + '\'' +
                ", fk_plano_id=" + fk_plano_id +
                '}';
    }
}
