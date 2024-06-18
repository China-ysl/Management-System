package org.lingge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lingge.domain.entity.Category2;
import org.lingge.domain.entity.Category3;
import org.lingge.mapper.Category3Mapper;
import org.lingge.service.Category3Service;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Category3)表服务实现类
 *
 * @author makejava
 * @since 2024-05-28 22:55:19
 */
@Service("category3Service")
public class Category3ServiceImpl extends ServiceImpl<Category3Mapper, Category3> implements Category3Service {

    @Override
    public List<Category3> getAttr3(Category3 category3) {
        LambdaQueryWrapper<Category3> queryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Category3> wrapper = queryWrapper.eq(Category3::getCategory2id, category3.getCategory2id());
        List<Category3> list = list(wrapper);
        return list ;
    }
}
