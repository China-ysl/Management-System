package org.lingge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lingge.domain.entity.Category2;
import org.lingge.domain.vo.Category2Vo;
import org.lingge.mapper.Category2Mapper;
import org.lingge.service.Category2Service;
import org.lingge.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Category2)表服务实现类
 *
 * @author makejava
 * @since 2024-05-28 00:10:44
 */
@Service("category2Service")
public class Category2ServiceImpl extends ServiceImpl<Category2Mapper, Category2> implements Category2Service {
    @Override
    public List<Category2Vo> getAttr2(Category2 category2) {
        LambdaQueryWrapper<Category2> queryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Category2> wrapper = queryWrapper.eq(Category2::getCategory1id, category2.getCategory1id());

        List<Category2> list = list(wrapper);
        List<Category2Vo> listVo = BeanCopyUtils.copyList(list, Category2Vo.class);
        return listVo ;
    }
}
