package com.fererlab.spring.app.controller;

import com.fererlab.spring.app.ui.InternalFrame;
import com.fererlab.spring.app.util.CallBack;

public interface Controller {

    InternalFrame getView();

    void init();

    void setCallBack(CallBack callBack);

}
