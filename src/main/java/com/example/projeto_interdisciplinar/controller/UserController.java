package com.example.projeto_interdisciplinar.controller;

import com.example.projeto_interdisciplinar.entity.Usuario;
import com.example.projeto_interdisciplinar.service.LogService;
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
    @Autowired
    private LogService logService;
    @GetMapping("/all")
    public List<Usuario> getUsers(){
        return userService.getUser();
    }
    @PostMapping("/insert")
    public Usuario insert(@RequestBody Usuario user){
        logService.generateLog("Created account", user.getId());
        return userService.addUser(user);
    }
    @PutMapping("/update/{id}/{email}")
    public ResponseEntity updateEmail(@PathVariable int id, @PathVariable String email){
        userService.updateEmail(id, email);
        logService.generateLog("update email", id);
        return ResponseEntity.ok("Email atualizado");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        userService.delectUser(id);
        logService.generateLog("delete account", id);
        return ResponseEntity.ok("Usuario excluido");
    }
    @GetMapping("/verifyaccount")
    public boolean verifyAccount(@RequestParam String email, @RequestParam String senha){
        return userService.verifyAccount(email, senha);
    }
    @GetMapping("/getByEmail")
    public ResponseEntity getById(@RequestParam String email){
        return userService.getUserByEmail(email);
    }



}
