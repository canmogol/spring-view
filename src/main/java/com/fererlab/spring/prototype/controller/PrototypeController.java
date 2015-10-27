package com.fererlab.spring.prototype.controller;

import com.fererlab.spring.app.controller.BaseController;
import com.fererlab.spring.prototype.view.PrototypeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrototypeController extends BaseController {

    private UserController userController;

    @Override
    public void init() {
        super.init();
        PrototypeView view = (PrototypeView) getView();
        view.getOpenUserViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openUserController();
            }
        });
    }

    private void openUserController() {
        userController.init();
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

}
