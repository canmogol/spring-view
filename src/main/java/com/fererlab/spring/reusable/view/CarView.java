package com.fererlab.spring.reusable.view;

import com.fererlab.spring.app.ui.SwingInternalFrame;
import com.fererlab.spring.reusable.model.CarModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarView extends SwingInternalFrame {

    private JTextArea textArea;

    public CarView() {
        super(200, 400, 920, 10);
    }

    @Override
    public void init() {
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
                getListener().actionPerformed(new CarModel());
            }
        });
        panel.add(button);

        add(panel);
    }

    public void addBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.textArea.append(brand + "\n");
        }
    }

}
