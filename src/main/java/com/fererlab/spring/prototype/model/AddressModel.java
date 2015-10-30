package com.fererlab.spring.prototype.model;

import com.fererlab.spring.core.model.Model;

public class AddressModel implements Model {

    private String addressText;

    public AddressModel(String addressText) {
        this.addressText = addressText;
    }

    public String getAddressText() {
        return addressText;
    }
}
