package com.oreki.openapi.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Fu Qiujie
 * @since 2023/3/8
 */

@Data
public class InterfaceInfoAddRequest implements Serializable {

    /**
     * 接口名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String responseHeader;

    /**
     * 请求类型
     */
    private String method;

    private static final long serialVersionUID = 1L;
}