package com.fererlab.spring.prototype.controller;

import com.fererlab.spring.core.controller.BaseController;
import com.fererlab.spring.core.model.AlertMessage;
import com.fererlab.spring.core.model.Model;
import com.fererlab.spring.prototype.model.AddressModel;
import com.fererlab.spring.prototype.model.GenerateNewAddressModel;
import com.fererlab.spring.prototype.model.PredefinedAddress;

import java.util.Random;


public class AddressController extends BaseController {

    @Override
    public void init() {
        super.init();
        getView().notify(new PredefinedAddress((new Random().nextInt(4) + 1) + " Avenue"));
    }

    @Override
    public void actionPerformed(Model model) {
        if (model instanceof AddressModel) {
            String address = ((AddressModel) model).getAddressText();
            if (address != null && !address.trim().isEmpty()) {
                getCallBack().call(address);
            } else {
                getView().notify(new AlertMessage("Address field cannot be blank"));
            }
        } else if (model instanceof GenerateNewAddressModel) {
            getView().notify(new PredefinedAddress((new Random().nextInt(4) + 5) + " Street"));
        }
    }
}
