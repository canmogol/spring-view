package com.fererlab.spring.core.controller;

import com.fererlab.spring.core.ui.InternalFrame;
import com.fererlab.spring.core.util.CallBack;

public interface Controller {

    InternalFrame getView();

    void init();

    void setCallBack(CallBack callBack);

}
