package com.fererlab.spring.reusable.model;

import com.fererlab.spring.core.action.BaseActionModel;

public class BrandModel extends BaseActionModel {

    private String brandName;

    public BrandModel(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }
}
