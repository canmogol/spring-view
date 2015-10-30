package com.fererlab.module.reusable.controller;

import com.fererlab.core.controller.BaseController;
import com.fererlab.core.model.Model;
import com.fererlab.core.common.CallBack;
import com.fererlab.module.reusable.view.swing.CarView;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CarController extends BaseController implements CallBack, ApplicationContextAware {

    private ApplicationContext applicationContext;

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

    @Override
    public void actionPerformed(Model model) {
        BrandController brandController = applicationContext.getBean(BrandController.class);
        brandController.setCallBack(this);
        brandController.init();
    }
}
