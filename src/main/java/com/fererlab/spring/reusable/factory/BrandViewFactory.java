package com.fererlab.spring.reusable.factory;

import com.fererlab.spring.reusable.view.BrandView;

import java.util.ArrayList;
import java.util.List;

public class BrandViewFactory {

    private static List<BrandView> brandViewList = new ArrayList<>();

    public BrandView createBrandView() {
        for (BrandView brandView : brandViewList) {
            if (brandView.isReusable()) {
                return brandView;
            }
        }
        BrandView brandView = new BrandView();
        brandViewList.add(brandView);
        return brandView;
    }

}
