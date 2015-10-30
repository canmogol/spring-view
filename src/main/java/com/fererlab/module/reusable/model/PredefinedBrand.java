package com.fererlab.module.reusable.model;

import com.fererlab.core.model.Model;

public class PredefinedBrand implements Model{

    private final String brand;

    public PredefinedBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
