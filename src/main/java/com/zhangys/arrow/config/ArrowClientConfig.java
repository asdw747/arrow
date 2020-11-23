package com.zhangys.arrow.config;

import lombok.Data;

import java.util.Map;

@Data
public class ArrowClientConfig {
    private String service;
    private String host;
    private int port;
    private int timeout = 3000;
    private int maxConnections = 128;
}
