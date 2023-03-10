package com.oreki.openapi.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.oreki.openapi.annotation.AuthCheck;
import com.oreki.openapi.common.BaseResponse;
import com.oreki.openapi.common.DeleteRequest;
import com.oreki.openapi.common.ErrorCode;
import com.oreki.openapi.common.ResultUtils;
import com.oreki.openapi.constant.UserConstant;
import com.oreki.openapi.exception.BusinessException;
import com.oreki.openapi.exception.ThrowUtils;
import com.oreki.openapi.model.dto.interfaceInfo.InterfaceInfoAddRequest;
import com.oreki.openapi.model.dto.interfaceInfo.InterfaceInfoInvokeRequest;
import com.oreki.openapi.model.dto.interfaceInfo.InterfaceInfoQueryRequest;
import com.oreki.openapi.model.dto.interfaceInfo.InterfaceInfoUpdateRequest;
import com.oreki.openapi.model.entity.InterfaceInfo;
import com.oreki.openapi.model.entity.User;
import com.oreki.openapi.model.vo.InterfaceInfoVO;
import com.oreki.openapi.service.InterfaceInfoService;
import com.oreki.openapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/interfaceInfo")
@Slf4j
public class InterfaceInfoController {

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @Resource
    private UserService userService;

    private final static Gson GSON = new Gson();

    // region 增删改查

    @GetMapping("/get/{id}")
    public BaseResponse<InterfaceInfoVO> getInterfaceInfo(@PathVariable Long id) {
        InterfaceInfoVO interfaceInfoVO = interfaceInfoService.getInterfaceInfo(id);
        return interfaceInfoVO == null ? ResultUtils.error(ErrorCode.OPERATION_ERROR) : ResultUtils.success(interfaceInfoVO);
    }

    /**
     * 创建
     *
     * @param interfaceInfoAddRequest
     * @param request
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Long> addInterfaceInfo(@RequestBody InterfaceInfoAddRequest interfaceInfoAddRequest, HttpServletRequest request) {
        if (interfaceInfoAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        BeanUtils.copyProperties(interfaceInfoAddRequest, interfaceInfo);
        interfaceInfoService.validInterfaceInfo(interfaceInfo, true);
        User loginUser = userService.getLoginUser(request);
        interfaceInfo.setUserId(loginUser.getId());
        boolean result = interfaceInfoService.save(interfaceInfo);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newInterfaceInfoId = interfaceInfo.getId();
        return ResultUtils.success(newInterfaceInfoId);
    }

    /**
     * 删除
     *
     * @param deleteRequest
     * @param request
     * @return
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteInterfaceInfo(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.getLoginUser(request);
        long id = deleteRequest.getId();
        // 判断是否存在
        InterfaceInfo oldInterfaceInfo = interfaceInfoService.getById(id);
        ThrowUtils.throwIf(oldInterfaceInfo == null, ErrorCode.NOT_FOUND_ERROR);
        // 仅本人或管理员可删除
        if (!oldInterfaceInfo.getUserId().equals(user.getId()) && !userService.isAdmin(request)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        boolean b = interfaceInfoService.removeById(id);
        return ResultUtils.success(b);
    }

    /**
     * 更新（仅管理员）
     *
     * @param interfaceInfoUpdateRequest
     * @return
     */
    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateInterfaceInfo(@RequestBody InterfaceInfoUpdateRequest interfaceInfoUpdateRequest) {
        Boolean result = interfaceInfoService.updateInterfaceInfo(interfaceInfoUpdateRequest);
        return result ? ResultUtils.success(true) : ResultUtils.error(ErrorCode.OPERATION_ERROR, "更新失败");
    }


    @PostMapping("/invoke")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Object> invokeInterface(@RequestBody InterfaceInfoInvokeRequest interfaceInfoInvokeRequest
    ,HttpServletRequest request) {
        Object data = interfaceInfoService.invokeInterface(interfaceInfoInvokeRequest,request);
        return data!=null ? ResultUtils.success(data) : ResultUtils.error(ErrorCode.OPERATION_ERROR, "调用失败");
    }

    @PostMapping("/online/{id}")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> onlineInterface(@PathVariable Long id) {
        Boolean result = interfaceInfoService.onlineInterface(id);
        return result ? ResultUtils.success(true) : ResultUtils.error(ErrorCode.OPERATION_ERROR, "上线失败");
    }

    @PostMapping("/offline/{id}")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> offlineInterface(@PathVariable Long id) {
        Boolean result = interfaceInfoService.offlineInterface(id);
        return result ? ResultUtils.success(true) : ResultUtils.error(ErrorCode.OPERATION_ERROR, "下线失败");
    }


    @GetMapping("/list/page")
    public BaseResponse<Page<InterfaceInfoVO>> listInterfaceInfoVOByPage(InterfaceInfoQueryRequest interfaceInfoQueryRequest,
                                                                         HttpServletRequest request) {
        long current = interfaceInfoQueryRequest.getCurrent();
        long size = interfaceInfoQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<InterfaceInfo> interfaceInfoPage = interfaceInfoService.page(new Page<>(current, size),
                interfaceInfoService.getQueryWrapper(interfaceInfoQueryRequest));
        return ResultUtils.success(interfaceInfoService.getInterfaceInfoVOPage(interfaceInfoPage, request));
    }
}
