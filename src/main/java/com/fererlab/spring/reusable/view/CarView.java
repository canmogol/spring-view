package com.fererlab.spring.reusable.view;

import com.fererlab.spring.app.util.InternalFrame;

import javax.swing.*;

public class CarView extends InternalFrame {

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
        button.addActionListener(getListener());
        panel.add(button);

        add(panel);
    }

    public void addBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.textArea.append(brand + "\n");
        }
    }

}
