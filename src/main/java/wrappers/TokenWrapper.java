package wrappers;

import models.entities.Role;

public class TokenWrapper {

    private String token;

    private Role role;

    public TokenWrapper() {

    }

    public TokenWrapper(String token, Role role) {
        this.token = token;
        this.role = role;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "TokenWrapper [token=" + token + ", role=" + role + "]";
    }
}