package com.example.projeto_interdisciplinar.service.IMPL;

//import com.example.projeto_interdisciplinar.entity.Usuario;
//import com.example.projeto_interdisciplinar.entity.UsuarioCurso;
//import com.example.projeto_interdisciplinar.repo.CourseRepo;
//import com.example.projeto_interdisciplinar.repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class CourseServiceIMPL {
//    @Autowired
//    private CourseRepo courseRepo;
//
//    @Autowired
//    private UserRepo userRepo;
//    ResponseEntity findCourseByUserEmail(String email){
//        try{
//            int id_usuario = userRepo.findByEmail(email).getId();
//            int aula_atual = courseRepo.findCourseByUserId(id_usuario).getAula_atual();
//            Map<String, Integer> aula = new HashMap<>();
//            if(aula_atual % 4 == 0){
//                aula.put("num_aula", aula_atual);
//                aula.put("posicao_aula", 4);
//            } else if(aula_atual % 3 == 0){
//                aula.put("num_aula", aula_atual);
//                aula.put("posicao_aula", 3);
//            } else if(aula_atual % 2 == 0){
//                aula.put("num_aula", aula_atual);
//                aula.put("posicao_aula", 2);
//            } else if(aula_atual % 5 == 0){
//                aula.put("num_aula", aula_atual);
//                aula.put("posicao_aula", 5);
//            }
//            return ResponseEntity.ok(aula);
//        } catch (Exception e){
//            return ResponseEntity.internalServerError().body(e);
//        }
//    }
//}
