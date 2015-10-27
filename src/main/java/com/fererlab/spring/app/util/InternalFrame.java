package com.fererlab.spring.app.util;

import javax.swing.*;

public abstract class InternalFrame extends JInternalFrame {

    private int id;

    public InternalFrame(int width, int height, int x, int y) {
        super("", true, false, true, true);
        setSize(width, height);
        setLocation(x, y);
    }

    public abstract void init();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
