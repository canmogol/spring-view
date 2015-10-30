package com.fererlab.module.prototype.model;

import com.fererlab.core.model.Model;

public class PredefinedAddress implements Model{

    private final String address;

    public PredefinedAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
