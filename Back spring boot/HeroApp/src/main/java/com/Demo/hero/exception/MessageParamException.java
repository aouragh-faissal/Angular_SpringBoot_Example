package com.Demo.hero.exception;

public class MessageParamException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
    private String msg;

    public MessageParamException(String msg) {
        this.msg = msg;

    }

    public String getMsg() {
        return msg;
    }

}
