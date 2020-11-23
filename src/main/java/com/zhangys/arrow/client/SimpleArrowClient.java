package com.zhangys.arrow.client;

import com.zhangys.arrow.config.ArrowClientConfig;
import com.zhangys.arrow.model.Request;
import com.zhangys.arrow.model.Response;

public class SimpleArrowClient implements ArrowClient {

    private ArrowClientConfig clientConfig;

    public SimpleArrowClient(ArrowClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    @Override
    public Response process(Request var1, Integer var2) throws Exception {
        Response response = new Response();

        System.out.println("abc");

        return response;
    }

    @Override
    public void close() {

    }

}
