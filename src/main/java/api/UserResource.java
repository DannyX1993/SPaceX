package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controllers.UserController;
import models.entities.Role;
import wrappers.UserRegisterWrapper;

@RestController
@RequestMapping(Uris.VERSION)
public class UserResource {

    private UserController userController;

    @Autowired
    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @RequestMapping(value = Uris.USERS + Uris.USERS_VERSION, method = RequestMethod.GET)
    public String version()  {
        return "{version: " + Uris.VERSION.toString() + "}";
    }

    @RequestMapping(value = Uris.USERS, method = RequestMethod.GET)
    public String userData()  {
        return "Entra GET /players";
    }

    @RequestMapping(value = Uris.USERS, method = RequestMethod.POST)
    public void userRegister(@RequestBody UserRegisterWrapper user) {
        if(fieldsValidation(user)) {
            this.userController.registration(user, Role.PLAYER);
        }
    }

    public boolean fieldsValidation(UserRegisterWrapper user) {
        if(user.getNickname() == null || user.getPassword() == null) {
            return false;
        }
        return true;
    }
}
