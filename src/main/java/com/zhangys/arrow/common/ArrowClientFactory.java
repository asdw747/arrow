package com.zhangys.arrow.common;

import com.zhangys.arrow.client.ArrowClient;
import com.zhangys.arrow.client.ArrowClientInvocationHandler;
import com.zhangys.arrow.client.SimpleArrowClient;
import com.zhangys.arrow.config.ArrowClientConfig;
import com.zhangys.arrow.config.ServiceConfig;

import java.lang.reflect.Proxy;

public class ArrowClientFactory {

    public ArrowClientFactory() {
    }

    public static <T> T create(ArrowClientConfig config, Class<T> clazz) {
        return create(config, clazz, null);
    }

    public static <T> T create(ArrowClientConfig config, Class<T> clazz, ServiceConfig serviceConfig) {
        if (config != null) {

            ArrowClient client = new SimpleArrowClient(config);
            if (serviceConfig == null) {
                serviceConfig = new ServiceConfig();
            }

            ArrowClientInvocationHandler handler = new ArrowClientInvocationHandler(client, clazz, serviceConfig);
            return (T) Proxy.newProxyInstance(ArrowClientFactory.class.getClassLoader(), new Class[]{clazz}, handler);
        } else {
            throw new IllegalArgumentException("config error");
        }
    }

}
