package com.fererlab.spring.prototype.view;

import com.fererlab.spring.app.ui.SwingInternalFrame;
import com.fererlab.spring.reusable.model.ReusableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReusableView extends SwingInternalFrame {

    public ReusableView() {
        super(200, 70, 700, 10);
    }

    @Override
    public void init() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton();
        button.setText("Open Car View");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getListener().actionPerformed(new ReusableModel());
            }
        });
        panel.add(button);

        add(panel);
    }
}