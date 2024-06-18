package org.lingge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.entity.Spu;
import org.lingge.domain.vo.SpuVo;
import org.lingge.mapper.SpuMapper;
import org.lingge.service.SpuService;
import org.lingge.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;

/**
 * (Spu)表服务实现类
 *
 * @author makejava
 * @since 2024-06-17 13:30:53
 */
@Service("spuService")
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements SpuService {


    @Override
    public ResponseResult<SpuVo> selectAll(Integer pageNum, Integer pageSize, Spu spu) {

        LambdaQueryWrapper<Spu> spuWrapper = new LambdaQueryWrapper<>();
        spuWrapper.like(StringUtils.hasText(spu.getSpuname()),Spu::getSpuname,spu.getSpuname());
        spuWrapper.eq(Spu::getCategory3id,spu.getCategory3id());
        Page<Spu> page = new Page<>();
        page.setSize(pageSize);
        page.setCurrent(pageNum);
        page(page,spuWrapper);
//        Bean拷贝
        List<SpuVo> spuVos = BeanCopyUtils.copyList(page.getRecords(), SpuVo.class);
//        封装返回 Page<SpuVo>
        Page<SpuVo> Page = new Page<>();
        Page.setRecords(spuVos);
        Page.setTotal(page.getTotal());
        return ResponseResult.okResult(Page);
    }
}
