//package com.example.projeto_interdisciplinar.repo;
//
//import com.example.projeto_interdisciplinar.entity.Usuario;
//import com.example.projeto_interdisciplinar.entity.UsuarioCurso;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface CourseRepo extends JpaRepository<Usuario,Integer> {
//    @Query("SELECT u FROM UsuarioCurso u WHERE u.fk_usuario_id = :id")
//    UsuarioCurso findCourseByUserId(int id);
//}
