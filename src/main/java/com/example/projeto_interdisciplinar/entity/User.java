package com.example.projeto_interdisciplinar.entity;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "usuarios")
public class User {
    @Id
    private String id;
    private String name;
    private String imageUrl;
    private int points;
    private boolean plain;
    private String email;
    private int kitCoins;
    private String password;
    private Date data_nasc;
    private ArrayList<String> mochila;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isPlain() {
        return plain;
    }

    public void setPlain(boolean plain) {
        this.plain = plain;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getKitCoins() {
        return kitCoins;
    }

    public void setKitCoins(int kitCoins) {
        this.kitCoins = kitCoins;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public ArrayList<String> getMochila() {
        return mochila;
    }

    public void setMochila(ArrayList<String> mochila) {
        this.mochila = mochila;
    }
}
