package com.fererlab.spring.app.util;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class InternalFrame extends JInternalFrame {

    private ActionListener listener;
    private int id;

    public InternalFrame(int width, int height, int x, int y) {
        super("", true, false, true, true);
        setSize(width, height);
        setLocation(x, y);
    }

    public abstract void init();

    public void setActionListener(ActionListener listener) {
        this.listener = listener;
    }

    public ActionListener getListener() {
        return listener;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
