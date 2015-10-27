package com.fererlab.spring.reusable.controller;

import com.fererlab.spring.app.controller.BaseController;
import com.fererlab.spring.reusable.view.ReusableView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReusableController extends BaseController {

    private CarController carController;

    @Override
    public void init() {
        super.init();
        ReusableView view = (ReusableView) getView();
        view.getOpenCarViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCarController();
            }
        });
    }

    private void openCarController() {
        carController.init();
    }

    public CarController getCarController() {
        return carController;
    }

    public void setCarController(CarController carController) {
        this.carController = carController;
    }

}
