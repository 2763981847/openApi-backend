package com.oreki.openapi.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 更新请求
 *
 * @author Oreki
 */
@Data
public class InterfaceInfoUpdateRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 接口名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 请求参数
     */
    private String requestParams;

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
     * 接口状态（0 - 关闭， 1 - 开启））
     */
    private Integer status;

    /**
     * 请求类型
     */
    private String method;


    private static final long serialVersionUID = 1L;
}