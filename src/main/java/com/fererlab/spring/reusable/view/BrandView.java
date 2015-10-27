package com.fererlab.spring.reusable.view;

import com.fererlab.spring.app.util.InternalFrame;
import com.fererlab.spring.app.util.Reusable;

import javax.swing.*;

public class BrandView extends InternalFrame implements Reusable {

    private static int count = 0;
    private boolean reusable = false;
    private JButton createBrandButton;
    private JTextField brandField;

    public BrandView() {
        // set dimensions and location
        super(250, 100, 1140, 10 + (count * 300));
        setTitle("Brand View #" + count);
        setLocation(1140 + (count * 10), 10 + (count * 10));
        setId(count);
        count++;
        // create UI elements
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        brandField = new JTextField();
        panel.add(brandField);
        createBrandButton = new JButton();
        createBrandButton.setText("Create Brand");
        createBrandButton.putClientProperty(JTextField.class, brandField);
        panel.add(createBrandButton);
        add(panel);
        try {
            System.out.println("BrandView creating super heavy UI " + getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        // do something time consuming
        try {
            System.out.println("BrandView initializing super heavy UI " + getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public JButton getCreateBrandButton() {
        return createBrandButton;
    }

    public JTextField getBrandField() {
        return brandField;
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        setReusable(!visible);
    }

    @Override
    public void setReusable(boolean reusable) {
        this.reusable = reusable;
    }

    @Override
    public boolean isReusable() {
        return this.reusable;
    }
}
