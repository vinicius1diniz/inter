package com.example.projeto_interdisciplinar.service;

import com.example.projeto_interdisciplinar.entity.Usuario;

import java.util.List;

public interface UserService {
    List<Usuario> getUser();
    boolean verifyAccount(String email);
    Usuario addUser(Usuario user);
    void updateEmail(int id, String email);
    void delectUser(int id);
}
