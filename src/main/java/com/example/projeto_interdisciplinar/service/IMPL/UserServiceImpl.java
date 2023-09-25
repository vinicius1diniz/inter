package com.example.projeto_interdisciplinar.service.IMPL;

import com.example.projeto_interdisciplinar.entity.Usuario;
import com.example.projeto_interdisciplinar.repo.UserRepo;
import com.example.projeto_interdisciplinar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Import the Service annotation

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<Usuario> getUser() {
        return userRepo.findAll();
    }
    public boolean verifyAccount( String email, String password){
        Usuario usuario = userRepo.findByEmail(email);
        if (usuario != null && usuario.getSenha() == password){
            return true;
        }
        return false;
    }
    @Override
    public Usuario addUser(Usuario user) {
        return userRepo.save(user);
    }

    @Override
    public void updateEmail(int id, String email) {
        Optional<Usuario> user1 = userRepo.findById(id);
        if (user1.isPresent()){
            Usuario usuario = user1.get();
            usuario.setEmail(email);
            userRepo.save(usuario);
        }
    }
    @Override
    public void delectUser(int id) {
        userRepo.deleteById(id);
    }
}
