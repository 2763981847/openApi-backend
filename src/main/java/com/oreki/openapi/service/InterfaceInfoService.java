package com.oreki.openapi.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oreki.openapi.common.BaseResponse;
import com.oreki.openapi.model.dto.interfaceInfo.InterfaceInfoInvokeRequest;
import com.oreki.openapi.model.dto.interfaceInfo.InterfaceInfoQueryRequest;
import com.oreki.openapi.model.dto.interfaceInfo.InterfaceInfoUpdateRequest;
import com.oreki.openapi.model.entity.InterfaceInfo;
import com.oreki.openapi.model.entity.InterfaceInfo;
import com.oreki.openapi.model.entity.Post;
import com.oreki.openapi.model.vo.InterfaceInfoVO;
import org.springframework.web.bind.annotation.RequestBody;

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
     * @param isAdd
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean isAdd);

    /**
     * 构建查询条件
     *
     * @param interfaceInfoQueryRequest
     * @return
     */
    QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest);

    /**
     * 更新接口信息
     * @param interfaceInfoUpdateRequest
     * @return
     */
    Boolean updateInterfaceInfo(InterfaceInfoUpdateRequest interfaceInfoUpdateRequest);

    /**
     * 分页获取接口信息封装
     * @param interfaceInfoPage
     * @param request
     * @return
     */
    Page<InterfaceInfoVO> getInterfaceInfoVOPage(Page<InterfaceInfo> interfaceInfoPage, HttpServletRequest request);

    /**
     * 上线接口
     * @param id
     * @return
     */
    Boolean onlineInterface(Long id);

    /**
     * 下线接口
     * @param id
     * @return
     */
    Boolean offlineInterface(Long id);

    /**
     * 根据ID查询接口信息
     * @param id
     * @return
     */
    InterfaceInfoVO getInterfaceInfo(Long id);

    /**
     * 调用接口
     * @param interfaceInfoInvokeRequest 用户请求调用信息
     * @param request 请求信息
     * @return
     */
    Object invokeInterface(InterfaceInfoInvokeRequest interfaceInfoInvokeRequest, HttpServletRequest request);
}
