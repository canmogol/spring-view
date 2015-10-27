package com.fererlab.spring.reusable.view;

import com.fererlab.spring.app.util.InternalFrame;

import javax.swing.*;

public class CarView extends InternalFrame {

    private JTextArea textArea;
    private JButton openBrandViewButton;

    public CarView() {
        // set dimensions and location
        super(200, 400, 920, 10);
        // create UI elements
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        textArea = new JTextArea();
        textArea.setColumns(40);
        textArea.setText("log:\n");
        panel.add(textArea);
        openBrandViewButton = new JButton();
        openBrandViewButton.setText("Open BrandView");
        panel.add(openBrandViewButton);
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

    public JButton getOpenBrandViewButton() {
        return openBrandViewButton;
    }
}
