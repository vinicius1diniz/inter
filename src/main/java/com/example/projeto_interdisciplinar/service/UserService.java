package com.example.projeto_interdisciplinar.service;

import com.example.projeto_interdisciplinar.entity.User;
import java.util.List;

public interface UserService {
    List<User> getUser();
    User addUser(User user);
    User delectUser(int id);
    User updateUser(int id, User user);
}
