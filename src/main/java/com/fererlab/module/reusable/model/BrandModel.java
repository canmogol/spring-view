package com.fererlab.module.reusable.model;

import com.fererlab.core.model.Model;

public class BrandModel implements Model {

    private String brandName;

    public BrandModel(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }
}
