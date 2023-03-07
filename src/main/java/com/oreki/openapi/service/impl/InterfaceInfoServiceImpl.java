package com.oreki.openapi.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oreki.openapi.mapper.InterfaceInfoMapper;
import com.oreki.openapi.model.entity.InterfaceInfo;
import com.oreki.openapi.service.InterfaceInfoService;
import org.springframework.stereotype.Service;

/**
* @author Oreki
* @description 针对表【interface_info(接口信息表)】的数据库操作Service实现
* @createDate 2023-03-07 23:05:30
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

}




