package com.fererlab.spring.reusable.factory;

import com.fererlab.spring.reusable.controller.BrandController;

import java.util.ArrayList;
import java.util.List;

public class BrandControllerFactory {
    private static List<BrandController> brandControllerList = new ArrayList<>();

    public BrandController createBrandController() {
        for (BrandController brandController : brandControllerList) {
            if (brandController.isReusable()) {
                return brandController;
            }
        }
        BrandController brandController = new BrandController();
        brandControllerList.add(brandController);
        return brandController;
    }
}
