package com.example.projeto_interdisciplinar.controller;

import com.example.projeto_interdisciplinar.entity.Usuario;
import com.example.projeto_interdisciplinar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/all")
    public List<Usuario> getUsers(){
        return userService.getUser();
    }
    @PostMapping("/insert")
    public Usuario insert(@RequestBody Usuario user){
        return userService.addUser(user);
    }
    @PutMapping("/update/{id}/{email}")
    public ResponseEntity updateEmail(@PathVariable int id, @PathVariable String email){
        userService.updateEmail(id, email);
        return ResponseEntity.ok("Email atualizado");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        userService.delectUser(id);
        return ResponseEntity.ok("Usuario excluido");
    }


}
