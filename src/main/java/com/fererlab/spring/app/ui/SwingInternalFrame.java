package com.fererlab.spring.app.ui;

import com.fererlab.spring.app.action.ActionModelListener;

import javax.swing.*;

public abstract class SwingInternalFrame extends JInternalFrame implements InternalFrame {

    private ActionModelListener listener;
    private int id;

    public SwingInternalFrame(int width, int height, int x, int y) {
        super("", true, false, true, true);
        setSize(width, height);
        setLocation(x, y);
    }

    @Override
    public void setActionListener(ActionModelListener listener) {
        this.listener = listener;
    }

    @Override
    public ActionModelListener getListener() {
        return listener;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}
