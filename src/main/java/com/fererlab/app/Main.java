package com.fererlab.app;

import com.fererlab.core.controller.Controller;
import com.fererlab.core.view.View;
import com.fererlab.module.prototype.controller.AddressController;
import com.fererlab.module.prototype.controller.PrototypeController;
import com.fererlab.module.prototype.controller.UserController;
import com.fererlab.module.reusable.controller.CarController;
import com.fererlab.module.reusable.controller.ReusableController;
import com.fererlab.module.reusable.factory.BrandControllerProvider;
import com.fererlab.module.reusable.factory.BrandViewProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.startSpringSwing();
        main.startSpringFX();
        main.startNoSpringSwing();
    }

    private void startSpringSwing() {
        new ClassPathXmlApplicationContext("ApplicationContext.xml", "Swing.xml");
    }

    private void startSpringFX() {
        new ClassPathXmlApplicationContext("ApplicationContext.xml", "JavaFX.xml");
    }

    private void startNoSpringSwing() {

        // CREATE SWING APP
        com.fererlab.app.swing.ui.ApplicationFrame uiListener = new com.fererlab.app.swing.ui.ApplicationFrame();
        uiListener.setTitle("UI Tester");
        uiListener.setMenuTitle("NC-Test");

        // CREATE SWING VIEWS
        View prototypeView = new com.fererlab.module.prototype.view.swing.PrototypeView();
        View userView = new com.fererlab.module.prototype.view.swing.UserView();
        View addressView1 = new com.fererlab.module.prototype.view.swing.AddressView();
        View addressView2 = new com.fererlab.module.prototype.view.swing.AddressView();
        View addressView3 = new com.fererlab.module.prototype.view.swing.AddressView();
        View reusableView = new com.fererlab.module.reusable.view.swing.ReusableView();
        View carView = new com.fererlab.module.reusable.view.swing.CarView();
        View brandView = new com.fererlab.module.reusable.view.swing.BrandView();

        // CREATE CONTROLLERS
        // Address Controller
        AddressController addressController1 = new AddressController();
        addressController1.setUiListener(uiListener);
        addressController1.setView(addressView1);
        AddressController addressController2 = new AddressController();
        addressController2.setUiListener(uiListener);
        addressController2.setView(addressView2);
        AddressController addressController3 = new AddressController();
        addressController3.setUiListener(uiListener);
        addressController3.setView(addressView3);
        // User Controller
        UserController userController = new UserController();
        userController.setUiListener(uiListener);
        userController.setView(userView);
        List<AddressController> addressControllers = new ArrayList<>();
        addressControllers.add(addressController1);
        addressControllers.add(addressController2);
        addressControllers.add(addressController3);
        userController.setAddressControllerList(addressControllers);
        // Prototype Controller
        PrototypeController prototypeController = new PrototypeController();
        prototypeController.setUiListener(uiListener);
        prototypeController.setView(prototypeView);
        prototypeController.setUserController(userController);

        // BrandController Provider for Car Controller
        BrandViewProvider brandViewProvider = new BrandViewProvider();
        BrandControllerProvider brandControllerProvider = new BrandControllerProvider();
        brandControllerProvider.setUiListener(uiListener);
        brandControllerProvider.setBrandViewProvider(brandViewProvider);

        // Car Controller
        CarController carController = new CarController();
        carController.setUiListener(uiListener);
        carController.setView(carView);
        carController.setBrandControllerProvider(brandControllerProvider);
        // Reusable Controller
        ReusableController reusableController = new ReusableController();
        reusableController.setUiListener(uiListener);
        reusableController.setView(reusableView);
        reusableController.setCarController(carController);

        // set menu for application
        Map<String, Controller> controllerMap = new HashMap<String, Controller>();
        controllerMap.put("Prototype-Test", prototypeController);
        controllerMap.put("ReusableFactory-Test", reusableController);
        uiListener.setMenuItemListenerMap(controllerMap);
        uiListener.start();

    }

}
