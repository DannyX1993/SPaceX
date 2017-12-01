package wrappers;

import java.util.Date;

public class UserRegisterWrapper {

    String nickname;

    String password;

    //Date lastAccess;

    public UserRegisterWrapper() {

    }

    public UserRegisterWrapper(String nickname/*, Date lastAccess*/) {
        this.nickname = nickname;
        //this.lastAccess = lastAccess;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /*public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }*/

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    /*public Date getLastAccess() {
        return lastAccess;
    }*/
}
