package com.fererlab.spring.reusable.view;

import com.fererlab.spring.app.util.InternalFrame;

import javax.swing.*;

public class PrototypeView extends InternalFrame {

    public PrototypeView() {
        super(200, 70, 10, 10);
    }

    @Override
    public void init() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton();
        button.setText("Open User View");
        button.addActionListener(getListener());
        panel.add(button);

        add(panel);
    }
}