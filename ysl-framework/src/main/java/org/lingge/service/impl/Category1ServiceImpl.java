package org.lingge.service.impl;

import org.lingge.domain.entity.Category1;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lingge.constants.SystemConstants;
import org.lingge.domain.ResponseResult;
import org.lingge.mapper.Category1Mapper;
import org.lingge.service.Category1Service;
import org.lingge.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Category1)表服务实现类
 *
 * @author makejava
 * @since 2024-05-27 15:09:39
 */
@Service("category1Service")
public class Category1ServiceImpl extends ServiceImpl<Category1Mapper, Category1> implements Category1Service {
    @Override
    public ResponseResult getAttr() {
        LambdaQueryWrapper<Category1> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category1::getDelFlag, SystemConstants.NORMAL_USE);
        List<Category1> List = list(queryWrapper);
//        转化vo
        List<Category1> brandList = BeanCopyUtils.copyList(List, Category1.class);
//        封装返回
        return ResponseResult.okResult(brandList);
    }
}
