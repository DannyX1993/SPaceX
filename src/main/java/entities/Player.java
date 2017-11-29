package entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by danielgonzalez on 28/11/17.
 */
@Entity(name = "Players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, length = 50)
    private String nickname;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date lastAccess;

    public Player() {}

    public Player(Integer id, String nick) {
        this.id = id;
        this.nickname = nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player that = (Player) o;
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
}
