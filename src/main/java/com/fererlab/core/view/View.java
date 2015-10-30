package com.fererlab.core.view;

import com.fererlab.core.common.ActionListener;
import com.fererlab.core.model.Model;

public interface View {

    void setVisible(boolean visible);

    boolean isVisible();

    void setActionListener(ActionListener listener);

    ActionListener getListener();

    void init();

    void notify(Model model);

}
