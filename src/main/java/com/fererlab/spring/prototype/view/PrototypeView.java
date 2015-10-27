package com.fererlab.spring.prototype.view;

import com.fererlab.spring.app.util.InternalFrame;

import javax.swing.*;

public class PrototypeView extends InternalFrame {

    private JButton openUserViewButton;

    public PrototypeView() {
        // set dimension and location
        super(200, 70, 10, 10);
        // create UI elements
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        openUserViewButton = new JButton();
        openUserViewButton.setText("Open User View");
        panel.add(openUserViewButton);
        add(panel);
    }

    @Override
    public void init() {
        // do something time consuming
    }

    public JButton getOpenUserViewButton() {
        return openUserViewButton;
    }
}