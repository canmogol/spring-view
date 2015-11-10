package com.fererlab.module.reusable.factory;

import com.fererlab.module.reusable.controller.BrandController;

import java.util.ArrayList;
import java.util.List;

public class BrandControllerFactory {
    private static List<BrandController> brandControllerList = new ArrayList<>();
    private static BrandControllerFactory instance;

    private BrandControllerFactory() {
    }

    public static BrandControllerFactory getInstance() {
        if (instance == null) {
            instance = new BrandControllerFactory();
        }
        return instance;
    }

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
