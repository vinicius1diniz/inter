    package com.example.projeto_interdisciplinar.service.IMPL;

    import com.example.projeto_interdisciplinar.dto.RankingDTO;
    import com.example.projeto_interdisciplinar.dto.UserDTO;
    import com.example.projeto_interdisciplinar.entity.Usuario;
    import com.example.projeto_interdisciplinar.repo.UserRepo;
    import com.example.projeto_interdisciplinar.service.LogService;
    import com.example.projeto_interdisciplinar.service.UserService;
    import org.apache.coyote.Response;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service; // Import the Service annotation

    import java.util.List;
    import java.util.Objects;
    import java.util.Optional;

    @Service
    public class UserServiceImpl implements UserService {
        @Autowired
        private UserRepo userRepo;
        @Autowired
        private LogService logService;

        @Override
        public List<Usuario> getUser() {
            return userRepo.findAll();
        }
        public boolean verifyAccount( String email, String password){
            Usuario usuario = userRepo.findByEmail(email);
            if (usuario != null && Objects.equals(usuario.getSenha(), password)){
                return true;
            }
            return false;
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
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email não encontrado");
            }
        }
        @Override
        public ResponseEntity getRanking(){
            try{
                List<RankingDTO> ranking = userRepo.WeeklyRanking();
                return ResponseEntity.ok(ranking);
            } catch (Exception e){
                List<RankingDTO> ranking = userRepo.WeeklyRanking();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ranking);
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
    }
