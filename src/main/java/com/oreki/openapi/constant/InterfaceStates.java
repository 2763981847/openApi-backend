package com.oreki.openapi.constant;

/**
 * @author Fu Qiujie
 * @since 2023/3/14
 */
public enum InterfaceStates {

    ONLINE(1, "已上线"),
    OFFLINE(0, "已下线");

    /**
     * 状态码
     */
    private final int val;

    /**
     * 信息
     */
    private final String message;

    InterfaceStates(int val, String message) {
        this.val = val;
        this.message = message;
    }

    public int getVal() {
        return val;
    }

    public String getMessage() {
        return message;
    }
}
