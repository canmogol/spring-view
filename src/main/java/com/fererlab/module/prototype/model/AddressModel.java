package com.fererlab.module.prototype.model;

import com.fererlab.core.model.Model;

public class AddressModel implements Model {

    private String addressText;

    public AddressModel(String addressText) {
        this.addressText = addressText;
    }

    public String getAddressText() {
        return addressText;
    }
}
