package models.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by danielgonzalez on 28/11/17.
 */
@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, length = 50)
    private String nickname;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccess;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @Column(nullable = false)
    // Note: @ColumnTransformer(read = “pgp_sym_decrypt(creditCardNumber, ‘mySecretKey’)”, write = “pgp_sym_encrypt(?, ‘mySecretKey’)”)
    private String password;

    public User() {

    }

    public User(String nick, String passw, Role role, Date lastAccess) {
        this.nickname = nick;
        this.password = passw;
        this.role = role;
        this.lastAccess = lastAccess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;
        return id != null ? !id.equals(that.id) : that.id != null;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nick) {
        this.nickname = nick;
    }

    public Date getLastAccess() {
        return this.lastAccess;
    }

    public void setLastAccess(Date access) {
        this.lastAccess = access;
    }

    public Role getRole() { return this.role; }

    public void setRole(Role role) { this.role = role; }
}
