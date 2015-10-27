package com.fererlab.spring.reusable.view;

import com.fererlab.spring.app.util.InternalFrame;

import javax.swing.*;

public class ReusableView extends InternalFrame {

    private JButton openCarViewButton;

    public ReusableView() {
        // set dimensions and location
        super(200, 70, 700, 10);
        // create UI elements
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        openCarViewButton = new JButton();
        openCarViewButton.setText("Open Car View");
        panel.add(openCarViewButton);
        add(panel);
    }

    @Override
    public void init() {
        // do someting time consuming
    }

    public JButton getOpenCarViewButton() {
        return openCarViewButton;
    }
}