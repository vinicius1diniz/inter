package com.example.projeto_interdisciplinar.service;

import com.example.projeto_interdisciplinar.entity.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<Usuario> getUser();
    boolean verifyAccount(String email, String password);
    ResponseEntity getUserByEmail(String email);
    Usuario addUser(Usuario user);
    void updateEmail(int id, String email);
    void delectUser(int id);
    ResponseEntity getRanking();
}
