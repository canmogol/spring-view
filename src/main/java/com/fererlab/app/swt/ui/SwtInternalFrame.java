package com.fererlab.app.swt.ui;

import com.fererlab.core.common.ActionListener;
import com.fererlab.core.model.Model;
import com.fererlab.core.view.View;

public abstract class SwtInternalFrame implements View {

    private boolean visible;
    private ActionListener actionListener;

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }

    @Override
    public void notify(Model model) {
    }

    @Override
    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
}
