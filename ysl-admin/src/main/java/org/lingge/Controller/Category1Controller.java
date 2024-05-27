package org.lingge.Controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.entity.Category1;
import org.lingge.service.Category1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Category1)表控制层
 *
 * @author makejava
 * @since 2024-05-27 14:12:41
 */
@RestController
@RequestMapping("/Attr")
public class Category1Controller {
    /**
     * 服务对象
     */
    @Resource
    private Category1Service category1Service ;
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param category1 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Page<Category1> page, Category1 category1) {
        return ResponseResult.okResult(this.category1Service.page(page, new QueryWrapper<>(category1)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return ResponseResult.okResult(this.category1Service.getById(id));
    }

    /**
     * 新增数据
     *
     * @param category1 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseResult insert(@RequestBody Category1 category1) {
        return ResponseResult.okResult(this.category1Service.save(category1));
    }

    /**
     * 修改数据
     *
     * @param category1 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody Category1 category1) {
        return ResponseResult.okResult(this.category1Service.updateById(category1));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return ResponseResult.okResult(this.category1Service.removeByIds(idList));
    }
}

