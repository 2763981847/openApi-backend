package com.oreki.openapi.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oreki.openapi.model.dto.interfaceInfo.InterfaceInfoQueryRequest;
import com.oreki.openapi.model.entity.InterfaceInfo;
import com.oreki.openapi.model.entity.InterfaceInfo;
import com.oreki.openapi.model.vo.InterfaceInfoVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Oreki
 * @description 针对表【interface_info(接口信息表)】的数据库操作Service
 * @createDate 2023-03-07 23:05:30
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    /**
     * 数据校验
     *
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
