package com.fererlab.spring.reusable.controller;

import com.fererlab.spring.app.controller.BaseController;
import com.fererlab.spring.app.util.Reusable;
import com.fererlab.spring.reusable.view.BrandView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrandController extends BaseController implements Reusable {

    private boolean reusable = false;
    private BrandView view;

    @Override
    public void init() {
        super.init();
        setReusable(false);
        view = (BrandView) getView();
        view.getCreateBrandButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewBrand();
            }
        });
    }

    private void createNewBrand() {
        String brand = view.getBrandField().getText();
        if (brand != null && !brand.trim().isEmpty()) {
            view.getBrandField().setText("");
            getView().setVisible(false);
            setReusable(true);
            getCallBack().call(brand);
        }
    }

    @Override
    public void setReusable(boolean reusable) {
        this.reusable = reusable;
    }

    @Override
    public boolean isReusable() {
        return this.reusable;
    }
}
