package com.fererlab.spring.reusable.model;

import com.fererlab.spring.core.model.Model;

public class PredefinedBrand implements Model{

    private final String brand;

    public PredefinedBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
