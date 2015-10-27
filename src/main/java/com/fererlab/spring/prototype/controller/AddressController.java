package com.fererlab.spring.prototype.controller;

import com.fererlab.spring.app.controller.BaseController;
import com.fererlab.spring.prototype.view.AddressView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressController extends BaseController {

    private AddressView addressView;

    @Override
    public void init() {
        super.init();
        addressView = (AddressView) getView();
        addressView.getCreateAddressButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewAddress();
            }
        });
    }

    private void createNewAddress() {
        String address = addressView.getAddressTextField().getText();
        addressView.getAddressTextField().setText("");
        getCallBack().call(address);
    }

}
