package com.fererlab.spring.reusable.controller;

import com.fererlab.spring.app.controller.BaseController;
import com.fererlab.spring.app.util.Reusable;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BrandController extends BaseController implements Reusable {

    private boolean reusable = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getClientProperty(JTextField.class) != null) {
                JTextField brandField = (JTextField) button.getClientProperty(JTextField.class);
                String brand = brandField.getText();
                brandField.setText("");
                getView().setVisible(false);
                reusable = true;
                getCallBack().call(brand);
            }
        }
    }

    @Override
    public boolean isReusable() {
        return this.reusable;
    }
}
