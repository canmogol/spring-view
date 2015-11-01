package com.fererlab.app.fx.ui;

import com.fererlab.core.common.ActionListener;
import com.fererlab.core.model.AlertMessage;
import com.fererlab.core.model.Model;
import com.fererlab.core.view.View;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;

public abstract class FxInternalFrame extends Pane implements View {

    private ActionListener actionListener;

    public ActionListener getActionListener() {
        return actionListener;
    }

    @Override
    public void notify(Model model) {
        if (model instanceof AlertMessage) {
            AlertMessage alertMessage = (AlertMessage) model;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(alertMessage.getMessage());
            alert.showAndWait();
        }
    }

    @Override
    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
}
