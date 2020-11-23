package com.zhangys.arrow.client;

import com.zhangys.arrow.config.ServiceConfig;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ArrowClientInvocationHandler implements InvocationHandler {

    private Class<?> iface;
    private ArrowClient client;
    private ServiceConfig serviceConfig;

    public ArrowClientInvocationHandler(ArrowClient client, Class<?> iface, ServiceConfig serviceConfig) {
        this.client = client;
        this.iface = iface;
        this.serviceConfig = serviceConfig;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        client.process(null, 1);

        return null;
    }
}
