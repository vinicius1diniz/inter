package com.example.projeto_interdisciplinar.service;

import com.example.projeto_interdisciplinar.entity.Usuario;

import java.util.List;

public interface UserService {
    List<Usuario> getUser();
    Usuario addUser(Usuario user);
    void updateEmail(int id, String email);
    void delectUser(int id);
}
