package com.fererlab.spring.reusable.controller;

import com.fererlab.spring.app.controller.BaseController;
import com.fererlab.spring.app.action.ActionModel;
import com.fererlab.spring.app.util.Reusable;
import com.fererlab.spring.reusable.model.BrandModel;

public class BrandController extends BaseController implements Reusable {

    private boolean reusable = false;

    @Override
    public void init() {
        super.init();
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
    public void actionPerformed(ActionModel event) {
        if (event instanceof BrandModel) {
            String brand = ((BrandModel) event).getBrandName();
            if (brand != null && !brand.trim().isEmpty()) {
                getView().setVisible(false);
                setReusable(true);
                getCallBack().call(brand);
            }
        }
    }
}
