package com.zhangys.arrow.spring;

import com.zhangys.arrow.client.ArrowClient;
import com.zhangys.arrow.config.ArrowClientConfig;
import com.zhangys.arrow.config.ServiceConfig;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ClientDefinitionParser extends AbstractSingleBeanDefinitionParser {
    public ClientDefinitionParser() {
    }

    protected Class getBeanClass(Element element) {
        return ArrowClient.class;
    }

    protected void doParse(Element element, ParserContext ctx, BeanDefinitionBuilder bean) {
        ArrowClientConfig arrowClientConfig = new ArrowClientConfig();
        arrowClientConfig.setService(element.getAttribute("service"));

        List<Element> servicesElems = DomUtils.getChildElementsByTagName(element, "service");
        if (servicesElems != null && !servicesElems.isEmpty()) {
            Iterator var6 = servicesElems.iterator();

            while(var6.hasNext()) {
                Element child = (Element)var6.next();
                this.registerService(arrowClientConfig, ctx, child);
            }
        }

    }

    protected void registerService(ArrowClientConfig arrowClientConfig, ParserContext ctx, Element element) {
        String iface = element.getAttribute("interface");
        String beanName = null;
        if (element.hasAttribute("id")) {
            beanName = element.getAttribute("id");
        } else {
//            int pos = iface.lastIndexOf(46);
//            beanName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, iface.substring(pos + 1));
        }

        BeanDefinitionBuilder bean = BeanDefinitionBuilder.rootBeanDefinition("com.xiaomi.mifi.cactus.common.CactusClientFactory");
        bean.setFactoryMethod("easyCreate");
        bean.addConstructorArgValue(arrowClientConfig);
        bean.addConstructorArgValue(iface);
        List<Element> methodElements = DomUtils.getChildElementsByTagName(element, "method");
        if (element.hasAttribute("timeout") || methodElements != null && !methodElements.isEmpty()) {
            bean.addConstructorArgValue(this.createServiceConfig(element));
        }

        ctx.getRegistry().registerBeanDefinition(beanName, bean.getBeanDefinition());
    }

    protected ServiceConfig createServiceConfig(Element element) {
        ServiceConfig serviceConfig = new ServiceConfig();
        if (element.hasAttribute("timeout")) {
            serviceConfig.setTimeout(Integer.valueOf(element.getAttribute("timeout")));
        }

//        List<Element> methodElements = DomUtils.getChildElementsByTagName(element, "method");
//        if (methodElements != null && !methodElements.isEmpty()) {
//            Map<String, MethodConfig> methodConfigMap = new HashMap();
//            Iterator var5 = methodElements.iterator();
//
//            while(var5.hasNext()) {
//                Element ele = (Element)var5.next();
//                String name = ele.getAttribute("name");
//                MethodConfig methodConfig = new MethodConfig();
//                methodConfig.setTimeout(Integer.valueOf(ele.getAttribute("timeout")));
//                methodConfigMap.put(name, methodConfig);
//            }
//
//            serviceConfig.setMethodConfigMap(methodConfigMap);
//        }

        return serviceConfig;
    }

    public boolean shouldGenerateId() {
        return true;
    }
}
