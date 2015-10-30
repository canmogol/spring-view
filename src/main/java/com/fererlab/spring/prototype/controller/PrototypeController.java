package com.fererlab.spring.prototype.controller;

import com.fererlab.spring.core.controller.BaseController;
import com.fererlab.spring.core.model.Model;


public class PrototypeController extends BaseController {

    private UserController userController;

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void actionPerformed(Model model) {
        userController.init();
    }
}
