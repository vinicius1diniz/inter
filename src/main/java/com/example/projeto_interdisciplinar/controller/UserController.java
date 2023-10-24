package com.example.projeto_interdisciplinar.controller;
import com.example.projeto_interdisciplinar.dto.UserDTO;
import com.example.projeto_interdisciplinar.entity.Usuario;
import com.example.projeto_interdisciplinar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    @PutMapping("/foto")
    public ResponseEntity saveFoto(@RequestParam String email, @RequestParam String imagem){
        if(email != null){
            userService.saveFoto(email, imagem);
            return ResponseEntity.ok().body("Foto alterada com sucesso");
        }
        return ResponseEntity.badRequest().body("Erro, sem e-mail");
    }





}
