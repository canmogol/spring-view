package com.fererlab.spring.prototype.controller;

import com.fererlab.spring.app.controller.BaseController;
import com.fererlab.spring.app.action.ActionModel;
import com.fererlab.spring.prototype.model.AddressModel;


public class AddressController extends BaseController {

    @Override
    public void actionPerformed(ActionModel event) {
        if (event instanceof AddressModel) {
            String address = ((AddressModel) event).getAddressText();
            if (address != null) {
                getCallBack().call(address);
            }
        }
    }
}
