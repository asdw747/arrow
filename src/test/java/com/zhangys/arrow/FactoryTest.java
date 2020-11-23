package com.zhangys.arrow;

import com.zhangys.arrow.common.ArrowClientFactory;
import com.zhangys.arrow.config.ArrowClientConfig;
import com.zhangys.arrow.test.PiuIface;
import org.junit.Test;

public class FactoryTest {

    @Test
    public void test() {

        ArrowClientConfig config = new ArrowClientConfig();
        config.setHost("10.38.161.214");
        config.setPort(9586);
        config.setTimeout(3000);
        PiuIface piuIface = ArrowClientFactory.create(config, PiuIface.class);
        piuIface.piu();

        System.currentTimeMillis();
    }

}
