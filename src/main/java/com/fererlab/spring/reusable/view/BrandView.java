package com.fererlab.spring.reusable.view;

import com.fererlab.spring.app.util.InternalFrame;
import com.fererlab.spring.app.util.Reusable;

import javax.swing.*;

public class BrandView extends InternalFrame implements Reusable {

    private static int count = 0;
    private boolean reusable = false;

    public BrandView() {
        super(250, 100, 1140, 10 + (count * 300));
        setTitle("Brand View #" + count);
        setLocation(1140 + (count * 10), 10 + (count * 10));
        setId(count);
        count++;
        try {
            System.out.println("BrandView creating super heavy UI " + getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        try {
            System.out.println("BrandView initializing super heavy UI " + getId());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField brandField = new JTextField();
        panel.add(brandField);

        JButton button = new JButton();
        button.setText("Create Brand");
        button.putClientProperty(JTextField.class, brandField);
        button.addActionListener(getListener());
        panel.add(button);

        add(panel);
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
