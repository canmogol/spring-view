package com.fererlab.spring.reusable.factory;

import com.fererlab.spring.core.view.View;
import com.fererlab.spring.core.common.Reusable;

import java.util.ArrayList;
import java.util.List;

public class ReusableFactory<T extends View & Reusable> {

    private List<T> reusableList = new ArrayList<>();
    private Class<T> beanClass;

    @SuppressWarnings("unchecked")
    public View createReusableView() {
        View view = null;
        for (Reusable reusable : reusableList) {
            if (reusable.isReusable()) {
                view = (View) reusable;
                break;
            }
        }
        if (view == null && beanClass != null) {
            try {
                view = beanClass.newInstance();
                reusableList.add((T) view);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return view;
    }

    public void setBeanClass(Class<T> beanClass) {
        this.beanClass = beanClass;
    }
}
