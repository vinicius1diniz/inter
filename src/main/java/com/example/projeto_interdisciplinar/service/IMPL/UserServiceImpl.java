    package com.example.projeto_interdisciplinar.service.IMPL;

    import com.example.projeto_interdisciplinar.dto.RankingDTO;
    import com.example.projeto_interdisciplinar.entity.Usuario;
    import com.example.projeto_interdisciplinar.repo.UserRepo;
    import com.example.projeto_interdisciplinar.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Objects;
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
            try{
                Usuario usuario = userRepo.findByEmail(email);
                return usuario != null && Objects.equals(usuario.getSenha(), password);
            } catch (Exception e){
                return false;
            }
        }
        @Override
        public Usuario addUser(Usuario user) {
            return userRepo.save(user);
        }
        @Override
        public ResponseEntity getUserByEmail(String email){
            try{
                Usuario user = userRepo.findByEmail(email);
                return ResponseEntity.ok(user);
            } catch (Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
            }
        }
        @Override
        public ResponseEntity getRanking(){
            try{
                List<RankingDTO> ranking = userRepo.WeeklyRanking();
                return ResponseEntity.ok(ranking);
            } catch (Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
            }
        }
        @Override
        public ResponseEntity resetPassword(String email, String password){
            try{
                Usuario user = userRepo.findByEmail(email);
                user.setSenha(password);
                userRepo.save(user);
                return ResponseEntity.ok(user);
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email não encontrado");
            }
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

        @Override
        public void saveFoto(String email, String imagem){
            try{
            Usuario user1 = userRepo.findByEmail(email);
            user1.setFoto_perfil(imagem);
            userRepo.save(user1);
            } catch (Exception e){
                System.out.println(e);
            }
        }

    }
