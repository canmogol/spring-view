package com.fererlab.spring.app.ui;

import com.fererlab.spring.app.action.ActionModelListener;

public interface InternalFrame {

    void setLocation(int x, int y);

    void setSize(int width, int height);

    void setActionListener(ActionModelListener listener);

    ActionModelListener getListener();

    int getId();

    void setId(int id);

    void setVisible(boolean visible);

    boolean isVisible();

    void setSelected(boolean selected) throws Exception;

    boolean isSelected();

    void requestFocus();

    void init();

}
