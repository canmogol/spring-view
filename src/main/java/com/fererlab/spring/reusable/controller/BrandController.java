package com.fererlab.spring.reusable.controller;

import com.fererlab.spring.core.controller.BaseController;
import com.fererlab.spring.core.model.AlertMessage;
import com.fererlab.spring.core.model.Model;
import com.fererlab.spring.core.common.Reusable;
import com.fererlab.spring.reusable.model.BrandModel;
import com.fererlab.spring.reusable.model.PredefinedBrand;

import java.util.Random;

public class BrandController extends BaseController implements Reusable {

    private boolean reusable = false;

    @Override
    public void init() {
        super.init();
        getView().notify(new PredefinedBrand(new String[]{"Mazda", "Suzuki", "Honda"}[new Random().nextInt(3)]));
        setReusable(false);
    }

    @Override
    public void setReusable(boolean reusable) {
        this.reusable = reusable;
    }

    @Override
    public boolean isReusable() {
        return this.reusable;
    }

    @Override
    public void actionPerformed(Model model) {
        if (model instanceof BrandModel) {
            String brand = ((BrandModel) model).getBrandName();
            if (brand != null && !brand.trim().isEmpty()) {
                getView().setVisible(false);
                setReusable(true);
                getCallBack().call(brand);
            } else {
                getView().notify(new AlertMessage("Address field cannot be blank"));
            }
        }
    }
}
