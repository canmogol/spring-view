package com.fererlab.spring.reusable.controller;

import com.fererlab.spring.app.controller.BaseController;
import com.fererlab.spring.app.util.CallBack;
import com.fererlab.spring.reusable.view.CarView;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.awt.event.ActionEvent;

public class CarController extends BaseController implements CallBack, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void actionPerformed(ActionEvent e) {
        BrandController brandController = applicationContext.getBean(BrandController.class);
        brandController.setCallBack(this);
        brandController.init();
    }

    @Override
    public void call(Object o) {
        if (o instanceof String) {
            String brand = (String) o;
            CarView carView = (CarView) getView();
            carView.addBrand(brand);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
