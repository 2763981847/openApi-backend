package com.oreki.openapi.model.dto.interfaceInfo;

import lombok.Data;

/**
 * @author Fu Qiujie
 * @since 2023/3/14
 */
@Data
public class InterfaceInfoInvokeRequest {
    /**
     * id
     */
    Long id;

    /**
     * 用户请求参数
     */
    String userRequestParams;
}
