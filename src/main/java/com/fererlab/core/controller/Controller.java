package com.fererlab.core.controller;

import com.fererlab.core.view.View;
import com.fererlab.core.common.CallBack;

public interface Controller {

    View getView();

    void init();

    void setCallBack(CallBack callBack);

}
