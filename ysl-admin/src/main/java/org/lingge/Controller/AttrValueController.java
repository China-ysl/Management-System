package org.lingge.Controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.lingge.annotation.SystemLog;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.entity.Attrvalue;
import org.lingge.service.AttrvalueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Attrvalue)表控制层
 *
 * @author makejava
 * @since 2024-05-30 00:34:02
 */
@RestController
@RequestMapping("/AttrValue")
public class AttrValueController {
    /**
     * 服务对象
     */
    @Resource
    private AttrvalueService attrvalueService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param attrvalue 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Page<Attrvalue> page, Attrvalue attrvalue) {
        return ResponseResult.okResult(this.attrvalueService.page(page, new QueryWrapper<>(attrvalue)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return ResponseResult.okResult(this.attrvalueService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param attrvalue 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseResult insert(@RequestBody Attrvalue attrvalue) {
        return ResponseResult.okResult(this.attrvalueService.save(attrvalue));
    }
    @SystemLog(businessName = "批量新增AttrList接口")
    @PostMapping("/AttrListAdd")
    public ResponseResult batchAdd(@RequestBody List<Attrvalue> attrList) {
        return ResponseResult.okResult(this.attrvalueService.saveBatch(attrList));
    }

    /**
     * 修改数据
     *
     * @param attrvalue 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody Attrvalue attrvalue) {
        return ResponseResult.okResult(this.attrvalueService.updateById(attrvalue));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return ResponseResult.okResult(this.attrvalueService.removeByIds(idList));
    }
}

