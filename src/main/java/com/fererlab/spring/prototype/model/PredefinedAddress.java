package com.fererlab.spring.prototype.model;

import com.fererlab.spring.core.model.Model;

public class PredefinedAddress implements Model{

    private final String address;

    public PredefinedAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
