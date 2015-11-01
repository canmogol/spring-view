package com.fererlab.app.fx.ui;

import com.fererlab.core.common.UIListener;
import com.fererlab.core.controller.Controller;
import com.fererlab.core.view.View;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ApplicationFrame implements ApplicationListener, UIListener {

    private String menuTitle = "";
    private Map<String, Controller> menuItemListenerMap = new HashMap<>();
    private String title;
    private BorderPane borderPane = new BorderPane();
    private VBox leftPane = new VBox();
    private HBox centerPane = new HBox();

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public void showView(View view) {
        if (view instanceof FxInternalFrame) {
            FxInternalFrame internalFrame = (FxInternalFrame) view;
            if (!centerPane.getChildren().contains(internalFrame)) {
                centerPane.getChildren().add(internalFrame);
            }
            internalFrame.setVisible(true);
        }
    }

    public void start() {

        JFrame frame = new JFrame("Swing and JavaFX");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(1400, 650);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
    }

    private void initFX(JFXPanel fxPanel) {
        Scene scene = new Scene(borderPane, Color.ALICEBLUE);
        HBox menu = new HBox();

        borderPane.setTop(menu);
        borderPane.setLeft(leftPane);
        borderPane.setCenter(centerPane);

        for (final String menuTitle : menuItemListenerMap.keySet()) {
            Button menuButton = new Button();
            menu.getChildren().add(menuButton);
            menuButton.setText(menuTitle);
            menuButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Controller controller = menuItemListenerMap.get(menuTitle);
                    controller.init();
                }
            });
        }

        fxPanel.setScene(scene);
    }

}
