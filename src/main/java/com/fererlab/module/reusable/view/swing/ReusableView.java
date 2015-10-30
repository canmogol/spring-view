package com.fererlab.module.reusable.view.swing;

import com.fererlab.app.swing.ui.SwingInternalFrame;
import com.fererlab.module.reusable.model.ReusableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReusableView extends SwingInternalFrame {

    public ReusableView() {
        // set dimensions and location
        super(200, 70, 700, 10);

        // create UI
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton();
        button.setText("Open Car View");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActionListener().actionPerformed(new ReusableModel());
            }
        });
        panel.add(button);
        add(panel);
    }

    @Override
    public void init() {
        // do something time consuming
    }
}