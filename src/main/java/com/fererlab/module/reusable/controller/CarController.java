package com.fererlab.module.reusable.controller;

import com.fererlab.core.common.CallBack;
import com.fererlab.core.controller.BaseController;
import com.fererlab.core.model.Model;
import com.fererlab.module.reusable.factory.BrandControllerProvider;
import com.fererlab.module.reusable.view.swing.CarView;

public class CarController extends BaseController implements CallBack{

    private BrandControllerProvider brandControllerProvider;

    @Override
    public void call(Object o) {
        if (o instanceof String) {
            String brand = (String) o;
            CarView carView = (CarView) getView();
            carView.addBrand(brand);
        }
    }

    @Override
    public void actionPerformed(Model model) {
        BrandController brandController = brandControllerProvider.createBrandController();
        brandController.setCallBack(this);
        brandController.init();
    }

    public void setBrandControllerProvider(BrandControllerProvider brandControllerProvider) {
        this.brandControllerProvider = brandControllerProvider;
    }
}
