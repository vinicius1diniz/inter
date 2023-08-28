package com.example.projeto_interdisciplinar.controller;

import com.example.projeto_interdisciplinar.entity.User;
import com.example.projeto_interdisciplinar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/all")
    public List<User> getProducts(){
        return userService.getUser();
    }
    @PostMapping("/insert")
    public User insert(@RequestBody User user){
        return userService.addUser(user);
    }
    @PutMapping("/update/{id}")
    public User user(@RequestBody User user, @PathVariable int id){
        return userService.updateUser(id, user);
    }
    @DeleteMapping("/delete/{id}")
    public User delete(@PathVariable int id){
        return userService.delectUser(id);
    }


}
