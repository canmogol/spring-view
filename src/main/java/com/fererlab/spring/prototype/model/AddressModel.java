package com.fererlab.spring.prototype.model;

import com.fererlab.spring.app.action.BaseActionModel;

public class AddressModel extends BaseActionModel {

    private String addressText;

    public AddressModel(String addressText) {
        this.addressText = addressText;
    }

    public String getAddressText() {
        return addressText;
    }
}
