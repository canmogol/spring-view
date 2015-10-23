package com.fererlab.spring.app.controller;

import com.fererlab.spring.app.util.CallBack;
import com.fererlab.spring.app.util.InternalFrame;
import com.fererlab.spring.app.util.UIListener;

import java.awt.event.ActionListener;

public abstract class BaseController implements Controller, ActionListener{

    private InternalFrame view;
    private UIListener uiListener;
    private CallBack callBack;

    public void setView(InternalFrame view) {
        this.view = view;
        this.view.setActionListener(this);
    }

    public InternalFrame getView() {
        return view;
    }

    public UIListener getUiListener() {
        return uiListener;
    }

    public void setUiListener(UIListener uiListener) {
        this.uiListener = uiListener;
    }

    @Override
    public void init() {
        getView().init();
        uiListener.showView(getView());
    }

    public CallBack getCallBack() {
        return callBack;
    }

    @Override
    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
