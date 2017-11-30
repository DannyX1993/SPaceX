package models.entities;

/**
 * @enum Role
 *
 * Implementa los roles de los usuarios
 */
public enum Role {
    PLAYER, OPERATOR, ADMIN;

    public String getName() {
        return "ROLE_" + this.toString();
    }
}
