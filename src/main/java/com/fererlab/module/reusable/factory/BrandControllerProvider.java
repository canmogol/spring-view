package com.fererlab.module.reusable.factory;

import com.fererlab.core.common.UIListener;
import com.fererlab.module.reusable.controller.BrandController;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BrandControllerProvider implements ApplicationContextAware {

    private UIListener uiListener;
    private BrandViewProvider brandViewProvider;
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void setUiListener(UIListener uiListener) {
        this.uiListener = uiListener;
    }

    public void setBrandViewProvider(BrandViewProvider brandViewProvider) {
        this.brandViewProvider = brandViewProvider;
    }

    public BrandController createBrandController() {
        BrandController brandController;
        if (applicationContext != null) {
            brandController = applicationContext.getBean(BrandController.class);
        } else {
            brandController = BrandControllerFactory.getInstance().createBrandController();
            brandController.setUiListener(uiListener);
            brandController.setView(brandViewProvider.createBrandView());
        }
        return brandController;
    }
}
