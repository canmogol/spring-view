package com.fererlab.spring.core.view;

import com.fererlab.spring.core.common.ActionListener;
import com.fererlab.spring.core.model.Model;

public interface View {

    void setVisible(boolean visible);

    boolean isVisible();

    void setActionListener(ActionListener listener);

    ActionListener getListener();

    void init();

    void notify(Model model);

}
