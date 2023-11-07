package com.example.projeto_interdisciplinar.controller;
import com.example.projeto_interdisciplinar.dto.UserDTO;
import com.example.projeto_interdisciplinar.entity.Usuario;
import com.example.projeto_interdisciplinar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    @GetMapping("/all")
    public List<Usuario> getUsers(){
        return userService.getUser();
    }
    @PostMapping("/insert")
    public Usuario insert(@RequestBody UserDTO user){
        Usuario usuario = new Usuario(user);
        return userService.addUser(usuario);
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
    @GetMapping("/verifyaccount")
    public boolean verifyAccount(@RequestParam String email, @RequestParam String senha){
        return userService.verifyAccount(email, senha);
    }
    @GetMapping("/getByEmail")
    public ResponseEntity getById(@RequestParam String email){
        return userService.getUserByEmail(email);
    }
    @GetMapping("/ranking")
    public ResponseEntity ranking(){
        return userService.getRanking();
    }
    @PatchMapping("/password")
    public ResponseEntity resetPassword(@RequestParam String email, @RequestParam String password){
        return userService.resetPassword(email, password);
    }
    @GetMapping("/email")
    public ResponseEntity verifyEmailExits(@RequestParam String email){
        ResponseEntity response = userService.getUserByEmail(email);
        System.out.println(response);
        return response;
    }
    @PatchMapping("/foto")
    public ResponseEntity saveFoto(@RequestBody Map<String, String> requestMap) {
        String email = requestMap.get("email");
        String imagem = requestMap.get("imagem");
        HashMap<String, Object> response = new HashMap<>();
        if (email != null) {
            userService.saveFoto(email, imagem);
            response.put("response", "Foto alterada com sucesso");
            return ResponseEntity.ok().body(response);
        }
        response.put("response", "Erro, sem e-mail");
        return ResponseEntity.badRequest().body(response);
    }
}
