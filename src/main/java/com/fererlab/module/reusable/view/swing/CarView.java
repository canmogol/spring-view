package com.fererlab.module.reusable.view.swing;

import com.fererlab.app.swing.ui.SwingInternalFrame;
import com.fererlab.module.reusable.model.CarModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarView extends SwingInternalFrame {

    private JTextArea textArea;

    public CarView() {
        // set dimensions and location
        super(200, 400, 920, 10);

        // create UI
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        textArea = new JTextArea();
        textArea.setColumns(40);
        textArea.setText("log:\n");
        panel.add(textArea);
        JButton button = new JButton();
        button.setText("Open BrandView");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getActionListener().actionPerformed(new CarModel());
            }
        });
        panel.add(button);
        add(panel);
    }

    @Override
    public void init() {
        // do something time consuming
    }

    public void addBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.textArea.append(brand + "\n");
        }
    }

}
