package com.oreki.openapi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oreki.openapi.common.ErrorCode;
import com.oreki.openapi.common.ResultUtils;
import com.oreki.openapi.constant.CommonConstant;
import com.oreki.openapi.exception.BusinessException;
import com.oreki.openapi.exception.ThrowUtils;
import com.oreki.openapi.mapper.InterfaceInfoMapper;
import com.oreki.openapi.model.dto.interfaceInfo.InterfaceInfoQueryRequest;
import com.oreki.openapi.model.dto.interfaceInfo.InterfaceInfoUpdateRequest;
import com.oreki.openapi.model.entity.InterfaceInfo;
import com.oreki.openapi.model.entity.Post;
import com.oreki.openapi.model.vo.InterfaceInfoVO;
import com.oreki.openapi.model.vo.PostVO;
import com.oreki.openapi.service.InterfaceInfoService;
import com.oreki.openapi.utils.SqlUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Oreki
 * @description 针对表【interface_info(接口信息表)】的数据库操作Service实现
 * @createDate 2023-03-07 23:05:30
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean isAdd) {

        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        String url = interfaceInfo.getUrl();
        // 创建时，参数不能为空
        if (isAdd) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(name, url), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口名过长");
        }
    }

    @Override
    public QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        if (interfaceInfoQueryRequest == null) {
            return queryWrapper;
        }
        String name = interfaceInfoQueryRequest.getName();
        String description = interfaceInfoQueryRequest.getDescription();
        String url = interfaceInfoQueryRequest.getUrl();
        String requestHeader = interfaceInfoQueryRequest.getRequestHeader();
        String requestParams = interfaceInfoQueryRequest.getRequestParams();
        String responseHeader = interfaceInfoQueryRequest.getResponseHeader();
        Long userId = interfaceInfoQueryRequest.getUserId();
        Integer status = interfaceInfoQueryRequest.getStatus();
        String method = interfaceInfoQueryRequest.getMethod();
        String sortField = interfaceInfoQueryRequest.getSortField();
        String sortOrder = interfaceInfoQueryRequest.getSortOrder();
        queryWrapper.like(StringUtils.isNotBlank(name), "name", name)
                .like(StringUtils.isNotBlank(description), "description", description)
                .like(StringUtils.isNotBlank(url), "url", url)
                .like(StringUtils.isNotBlank(requestHeader), "request_header", requestHeader)
                .like(StringUtils.isNotBlank(responseHeader), "response_header", responseHeader)
                .like(StringUtils.isNotBlank(requestParams), "request_params", requestParams)
                .like(StringUtils.isNotBlank(method), "method", method)
                .eq(ObjectUtils.isNotEmpty(userId), "userId", userId)
                .eq(ObjectUtils.isNotEmpty(status), "status", status)
                .orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                        sortField);
        return queryWrapper;
    }

    @Override
    public Boolean updateInterfaceInfo(InterfaceInfoUpdateRequest interfaceInfoUpdateRequest) {
        if (interfaceInfoUpdateRequest == null || interfaceInfoUpdateRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        BeanUtils.copyProperties(interfaceInfoUpdateRequest, interfaceInfo);
        // 参数校验
        this.validInterfaceInfo(interfaceInfo, false);
        long id = interfaceInfoUpdateRequest.getId();
        // 判断是否存在
        InterfaceInfo oldInterfaceInfo = this.getById(id);
        ThrowUtils.throwIf(oldInterfaceInfo == null, ErrorCode.NOT_FOUND_ERROR);
        return this.updateById(interfaceInfo);
    }

    @Override
    public Page<InterfaceInfoVO> getInterfaceInfoVOPage(Page<InterfaceInfo> interfaceInfoPage, HttpServletRequest request) {
        List<InterfaceInfo> interfaceInfoList = interfaceInfoPage.getRecords();
        Page<InterfaceInfoVO> interfaceInfoVOPage = new Page<>(interfaceInfoPage.getCurrent(), interfaceInfoPage.getSize(), interfaceInfoPage.getTotal());
        if (CollectionUtils.isEmpty(interfaceInfoList)) {
            return interfaceInfoVOPage;
        }
        interfaceInfoVOPage.setRecords(
                interfaceInfoList.stream().map(interfaceInfo -> {
                    InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
                    BeanUtil.copyProperties(interfaceInfo, interfaceInfoVO);
                    return interfaceInfoVO;
                }).collect(Collectors.toList())
        );
        return interfaceInfoVOPage;
    }

    @Override
    public Boolean onlineInterface(Long id) {
        InterfaceInfoUpdateRequest interfaceInfoUpdateRequest = new InterfaceInfoUpdateRequest();
        interfaceInfoUpdateRequest.setId(id);
        interfaceInfoUpdateRequest.setStatus(1);
        return this.updateInterfaceInfo(interfaceInfoUpdateRequest);
    }

    public Boolean offlineInterface(Long id) {
        InterfaceInfoUpdateRequest interfaceInfoUpdateRequest = new InterfaceInfoUpdateRequest();
        interfaceInfoUpdateRequest.setId(id);
        interfaceInfoUpdateRequest.setStatus(0);
        return this.updateInterfaceInfo(interfaceInfoUpdateRequest);
    }
}




