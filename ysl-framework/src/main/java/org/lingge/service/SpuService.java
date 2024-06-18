package org.lingge.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.entity.Spu;
import org.lingge.domain.vo.PageVo;
import org.lingge.domain.vo.SpuVo;


/**
 * (Spu)表服务接口
 *
 * @author makejava
 * @since 2024-06-17 13:30:53
 */
public interface SpuService extends IService<Spu> {

    ResponseResult<SpuVo> selectAll(Integer pageNum, Integer pageSize, Spu spu);
}
