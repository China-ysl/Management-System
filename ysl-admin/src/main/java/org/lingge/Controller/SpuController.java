package org.lingge.Controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.entity.Spu;
import org.lingge.domain.vo.SpuVo;
import org.lingge.service.SpuService;
import org.lingge.utils.BeanCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Spu)表控制层
 *
 * @author makejava
 * @since 2024-06-17 13:30:51
 */
@RestController
@RequestMapping("/SPU")
public class SpuController {
    /**
     * 服务对象
     */
    @Resource
    private SpuService spuService;

    /**
     * 分页查询所有数据
     *
     * @param spu 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Integer pageNum, Integer pageSize, Spu spu) {
        return this.spuService.selectAll(pageNum,pageSize,spu);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return ResponseResult.okResult(this.spuService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param spu 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseResult insert(@RequestBody Spu spu) {
        return ResponseResult.okResult(this.spuService.save(spu));
    }

    /**
     * 修改数据
     *
     * @param spu 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody Spu spu) {
        return ResponseResult.okResult(this.spuService.updateById(spu));
    }
    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return ResponseResult.okResult(this.spuService.removeByIds(idList));
    }
}

