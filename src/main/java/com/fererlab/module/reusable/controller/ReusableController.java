package com.fererlab.module.reusable.controller;

import com.fererlab.core.controller.BaseController;
import com.fererlab.core.model.Model;

public class ReusableController extends BaseController {

    private CarController carController;

    public CarController getCarController() {
        return carController;
    }

    public void setCarController(CarController carController) {
        this.carController = carController;
    }

    @Override
    public void actionPerformed(Model model) {
        carController.init();
    }
}
