package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import models.daos.UserDao;
import models.entities.Role;
import models.entities.User;
import wrappers.UserRegisterWrapper;

import java.util.Date;

@Controller
public class UserController {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean registration(UserRegisterWrapper userWrapper, Role role) {
        if (userDao.findByNickname(userWrapper.getNickname()).size() == 0) {
            User user = new User(userWrapper.getNickname(), userWrapper.getPassword(), role, new Date());
            userDao.save(user);
            return true;
        } else {
            return false;
        }
    }

}