package com.fererlab.spring.prototype.view;

import com.fererlab.spring.app.util.InternalFrame;

import javax.swing.*;

public class ReusableView extends InternalFrame {

    public ReusableView() {
        super(200, 70, 700, 10);
    }

    @Override
    public void init() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton();
        button.setText("Open Car View");
        button.addActionListener(getListener());
        panel.add(button);

        add(panel);
    }
}