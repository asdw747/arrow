package com.zhangys.arrow.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {
    private long id;
    private Object value;
    private Exception exception;

    public Response() {
    }

    public Response(Object value) {
        this.value = value;
    }

    public String toString() {
        return "Response{exception=" + this.exception + ", value=" + this.value + '}';
    }

}

