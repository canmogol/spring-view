package com.fererlab.app.swing.ui;

import com.fererlab.core.controller.Controller;
import com.fererlab.core.view.View;
import com.fererlab.core.common.UIListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

public class ApplicationFrame extends JFrame implements ApplicationListener, UIListener {

    private String menuTitle = "";
    private Map<String, Controller> menuItemListenerMap = new HashMap<>();
    private JDesktopPane desktopPane;

    public void start() throws HeadlessException {
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
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    Controller controller = menuItemListenerMap.get(menuTitle);
                    controller.init();
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

    public void showView(final View view) {
        if (view instanceof JInternalFrame) {
            final JInternalFrame internalFrame = (JInternalFrame) view;
            internalFrame.setVisible(true);
            try {
                internalFrame.setSelected(true);
                internalFrame.requestFocus();
            } catch (Exception e1) {
            }
            for (Component component : desktopPane.getComponents()) {
                if (component.equals(internalFrame)) {
                    return;
                }
            }
            desktopPane.add((JComponent) internalFrame);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        internalFrame.setSelected(true);
                        internalFrame.requestFocus();
                    } catch (Exception e1) {
                    }
                }
            });
        }
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
            start();
        }
    }

}
