package com.example.projeto_interdisciplinar.entity;
import com.example.projeto_interdisciplinar.dto.UserDTO;
import com.google.api.client.util.DateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UsuarioCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fk_usuario_id;
    private int fk_curso_id;
    private int aula_atual;
    private Timestamp ultimo_acesso;

    public UsuarioCurso(int fk_usuario_id, int fk_curso_id) {
        this.fk_usuario_id = fk_usuario_id;
        this.fk_curso_id = fk_curso_id;
        this.aula_atual = 1;
        this.ultimo_acesso = new Timestamp(System.currentTimeMillis());
    }
}