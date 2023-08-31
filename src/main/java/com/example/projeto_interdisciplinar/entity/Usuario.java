package com.example.projeto_interdisciplinar.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import java.util.Date;

@Entity
public class Usuario {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Id
    private String email;
    private String nickname;
    private String name;
    private int points;
    private int plainId;

    private int kitCoins;
    private String password;
    private Date data_nasc;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPlainId() {
        return plainId;
    }

    public void setPlainId(int plainId) {
        this.plainId = plainId;
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

    public Usuario(String email, String nickname, String name, int points, int plainId, int kitCoins, String password, Date data_nasc) {
        this.email = email;
        this.nickname = nickname;
        this.name = name;
        this.points = points;
        this.plainId = plainId;
        this.kitCoins = kitCoins;
        this.password = password;
        this.data_nasc = data_nasc;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", points=" + points +
                ", plainId=" + plainId +
                ", kitCoins=" + kitCoins +
                ", password='" + password + '\'' +
                ", data_nasc=" + data_nasc +
                '}';
    }

    public long getId() {
        return id;
    }
}