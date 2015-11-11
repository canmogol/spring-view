package com.fererlab.module.reusable.controller;

import com.fererlab.core.controller.BaseController;
import com.fererlab.core.model.AlertMessage;
import com.fererlab.core.model.Model;
import com.fererlab.core.common.Reusable;
import com.fererlab.module.reusable.model.BrandModel;
import com.fererlab.module.reusable.model.PredefinedBrand;

import java.util.Random;

public class BrandController extends BaseController implements Reusable {

    private boolean reusable = false;

    @Override
    public void init() {
        super.init();
        getView().notify(new PredefinedBrand(
                        new String[]{
                                "Mazda", "Suzuki", "Honda", "Subaru", "Daihatsu", "Mitsubishi", "Nissan", "Toyota"
                        }[new Random().nextInt(8)])
        );
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
                getView().notify(new AlertMessage("Brand field cannot be blank"));
            }
        }
    }
}
