package models.entities;

import models.core.Encrypting;
import models.core.EncryptingAlgorithm;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Tokens")
public class Token {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn
    private User user;

    // TODO -> MEJORA: HACER QUE LOS TOKEN CADUQUEN Y QUIZÁS CON UN TOKEN VALIDADOR QUE TARDE MÁS EN CADUCAR Y PERMITA CREAR UN NUEVO TOKEN

    public Token() {
    }

    public Token(User user) {
        //assert user != null;
        this.user = user;
        this.value = Encrypting.base64UrlSafeEncrypt(EncryptingAlgorithm.SHA256, "" + user.getId() + Long.toString(new Date().getTime()));
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
