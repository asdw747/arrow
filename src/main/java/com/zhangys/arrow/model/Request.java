package com.zhangys.arrow.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Request implements Serializable {

    private long id;
    private String iface;
    private String method;
    private String paramSign;
    private Object[] params;
    private String sessionId;

    public Request() {
    }

    public Request(String iface, String method, String paramSign, Object[] params) {
        this.iface = iface;
        this.method = method;
        this.paramSign = paramSign;
        this.params = params;
    }

}
