package com.fererlab.spring.reusable.factory;

import com.fererlab.spring.app.ui.InternalFrame;
import com.fererlab.spring.app.ui.SwingInternalFrame;
import com.fererlab.spring.app.util.Reusable;

import java.util.ArrayList;
import java.util.List;

public class ReusableFactory<T extends SwingInternalFrame & Reusable> {

    private List<T> reusableList = new ArrayList<>();
    private Class<T> beanClass;

    @SuppressWarnings("unchecked")
    public InternalFrame createReusableView() {
        InternalFrame internalFrame = null;
        for (Reusable reusable : reusableList) {
            if (reusable.isReusable()) {
                internalFrame = (InternalFrame) reusable;
                break;
            }
        }
        if (internalFrame == null && beanClass != null) {
            try {
                internalFrame = beanClass.newInstance();
                reusableList.add((T) internalFrame);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return internalFrame;
    }

    public void setBeanClass(Class<T> beanClass) {
        this.beanClass = beanClass;
    }
}
