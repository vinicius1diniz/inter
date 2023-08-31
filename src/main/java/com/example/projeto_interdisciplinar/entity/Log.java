package com.example.projeto_interdisciplinar.entity;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "usuarios")
public class Log {
    @Id
    private String id;
    private String type;
    private String user;
    private LocalDateTime aconteceu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getAconteceu() {
        return aconteceu;
    }

    public void setAconteceu(LocalDateTime aconteceu) {
        this.aconteceu = aconteceu;
    }

}