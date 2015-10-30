package com.fererlab.spring.core.controller;

import com.fererlab.spring.core.common.ActionListener;
import com.fererlab.spring.core.view.View;
import com.fererlab.spring.core.common.CallBack;
import com.fererlab.spring.core.common.UIListener;


public abstract class BaseController implements Controller, ActionListener {

    private View view;
    private UIListener uiListener;
    private CallBack callBack;

    public void setView(View view) {
        this.view = view;
        this.view.setActionListener(this);
    }

    public View getView() {
        return view;
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
