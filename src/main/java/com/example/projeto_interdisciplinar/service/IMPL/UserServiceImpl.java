package com.example.projeto_interdisciplinar.service.IMPL;

import com.example.projeto_interdisciplinar.entity.User;
import com.example.projeto_interdisciplinar.repo.UserRepo;
import com.example.projeto_interdisciplinar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Import the Service annotation

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getUser() {
        return userRepo.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User delectUser(int id) {
        User user = userRepo.findById(id).get();
        userRepo.delete(user);
        return user;
    }

    @Override
    public User updateUser(int id, User user) {
        User newUser = userRepo.findById(id).get();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setKitCoins(user.getKitCoins());
        newUser.setPoints(user.getPoints());
        newUser.setPlain(user.isPlain());
        newUser.setImageUrl(user.getImageUrl());
        newUser.setData_nasc(user.getData_nasc());
        newUser.setMochila(user.getMochila());
        userRepo.save(newUser);
        return newUser;
    }
}
