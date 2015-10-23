package com.fererlab.spring.prototype.controller;

import com.fererlab.spring.app.controller.BaseController;

import java.awt.event.ActionEvent;

public class PrototypeController extends BaseController {

    private UserController userController;

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        userController.init();
    }
}
