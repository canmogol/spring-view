package com.fererlab.spring.app.util;

import com.fererlab.spring.app.controller.Controller;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

public class ApplicationFrame extends JFrame implements ApplicationListener, UIListener {

    private String menuTitle = "";
    private Map<String, Controller> menuItemListenerMap = new HashMap<>();
    private JDesktopPane desktopPane;

    private void init() throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(10, 10, screenSize.width - 10 * 2, screenSize.height - 10 * 2);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        desktopPane = new JDesktopPane();
        this.setContentPane(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu(menuTitle);
        menu.setMnemonic(KeyEvent.VK_N);

        for (final String menuTitle : menuItemListenerMap.keySet()) {
            JMenuItem menuItem = new JMenuItem(menuTitle);
            menuItem.setMnemonic(KeyEvent.VK_N);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Controller controller = menuItemListenerMap.get(menuTitle);
                    controller.init();
                    InternalFrame internalFrame = menuItemListenerMap.get(menuTitle).getView();
                    showView(internalFrame);
                }
            });
            menu.add(menuItem);
        }

        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        Dimension dimension = new Dimension(1400, 650);
        this.getContentPane().setPreferredSize(dimension);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
    }

    public void showView(final InternalFrame internalFrame) {
        internalFrame.setVisible(true);
        try {
            internalFrame.setSelected(true);
            internalFrame.requestFocus();
        } catch (PropertyVetoException e1) {
        }
        for (Component component : desktopPane.getComponents()) {
            if (component.equals(internalFrame)) {
                return;
            }
        }
        desktopPane.add(internalFrame);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    internalFrame.setSelected(true);
                    internalFrame.requestFocus();
                } catch (PropertyVetoException e1) {
                }
            }
        });
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public void setMenuItemListenerMap(Map<String, Controller> menuItemListenerMap) {
        this.menuItemListenerMap = menuItemListenerMap;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            init();
        }
    }
}
