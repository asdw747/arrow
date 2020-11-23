package com.zhangys.arrow.client;

import com.zhangys.arrow.model.Request;
import com.zhangys.arrow.model.Response;

public interface ArrowClient {

    Response process(Request var1, Integer var2) throws Exception;

    void close();

}
