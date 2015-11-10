package com.fererlab.module.reusable.factory;

import com.fererlab.core.view.View;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BrandViewProvider implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public View createBrandView() {
        View brandView;
        if (applicationContext != null) {
            brandView = applicationContext.getBean("brandView", View.class);
        } else {
            brandView = BrandViewFactory.getInstance().createBrandView();
        }
        return brandView;
    }
}
