package com.fererlab.spring.app.controller;

import com.fererlab.spring.app.util.CallBack;
import com.fererlab.spring.app.util.InternalFrame;

public interface Controller {

    InternalFrame getView();

    void init();

    void setCallBack(CallBack callBack);

}
