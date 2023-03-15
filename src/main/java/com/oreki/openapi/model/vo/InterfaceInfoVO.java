package com.oreki.openapi.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Fu Qiujie
 * @since 2023/3/8
 */
@Data
public class InterfaceInfoVO implements Serializable {
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
     * 接口状态（0 - 关闭， 1 - 开启））
     */
    private Integer status;

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
     * 请求类型
     */
    private String method;

    /**
     * 创建人
     */
    private Long userId;

    /**
     * 创建时间
     */
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

}
