package org.lingge.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.entity.Category3;
import org.lingge.service.Category3Service;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Category3)表控制层
 *
 * @author makejava
 * @since 2024-05-28 23:40:09
 */
@RestController
@RequestMapping("/Attr3")
public class Category3Controller {
    /**
     * 服务对象
     */
    @Resource
    private Category3Service category3Service;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param category3 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Page<Category3> page, Category3 category3) {
        return ResponseResult.okResult(this.category3Service.page(page, new QueryWrapper<>(category3)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return ResponseResult.okResult(this.category3Service.getById(id));
    }

    /**
     * 新增数据
     *
     * @param category3 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseResult insert(@RequestBody Category3 category3) {
        return ResponseResult.okResult(this.category3Service.save(category3));
    }

    /**
     * 批量新增数据
     *
     * @return 新增结果
     */
    @PostMapping("/batchAdd")
    public ResponseResult batchAdd(@RequestBody List<Category3> attrList) {
        return ResponseResult.okResult(this.category3Service.saveBatch(attrList));
    }

    /**
     * 修改数据
     *
     * @param category3 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody Category3 category3) {
        return ResponseResult.okResult(this.category3Service.updateById(category3));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return ResponseResult.okResult(this.category3Service.removeByIds(idList));
    }
}

