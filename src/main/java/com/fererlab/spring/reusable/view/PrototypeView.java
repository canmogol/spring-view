package com.fererlab.spring.reusable.view;

import com.fererlab.spring.app.ui.SwingInternalFrame;
import com.fererlab.spring.prototype.model.PrototypeModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrototypeView extends SwingInternalFrame implements ActionListener {

    private JButton openUserView;

    public PrototypeView() {
        // set dimensions and location
        super(200, 70, 10, 10);

        // create UI
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        openUserView = new JButton();
        openUserView.setText("Open User View");
        openUserView.addActionListener(this);
        panel.add(openUserView);
        add(panel);
    }

    @Override
    public void init() {
        // do something time consuming
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (openUserView.equals(e.getSource())) {
            getListener().actionPerformed(new PrototypeModel());
        }
    }
}