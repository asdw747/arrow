package com.zhangys.arrow.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class ArrowNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        this.registerBeanDefinitionParser("client", new ClientDefinitionParser());
    }
}
