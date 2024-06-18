package org.lingge.Controller;

import org.lingge.domain.ResponseResult;
import org.lingge.domain.entity.Category2;
import org.lingge.service.Category2Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Category2)表控制层
 *
 * @author makejava
 * @since 2024-05-28 00:09:54
 */
@RestController
@RequestMapping("/Attr2")
public class Category2Controller {
    /**
     * 服务对象
     */
    @Resource
    private Category2Service category2Service;

    /**
     * 根据一级分类id查询所有数据
     *
     * @param category2 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll( Category2 category2 ) {
        return ResponseResult.okResult(category2Service.getAttr2(category2));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseResult selectOne(@PathVariable(value = "category1id") Long id) {
        return ResponseResult.okResult(this.category2Service.getById(id));
    }

    /**
     * 批量新增数据
     *
     * @return 新增结果
     */
    @PostMapping("/batchAdd")
    public ResponseResult batchAdd(@RequestBody List<Category2> attrList) {
        return ResponseResult.okResult(this.category2Service.saveBatch(attrList));
    }

    /**
     * 新增数据
     *
     * @param category2 实体对象
     * @return 新增结果
     */
    @PostMapping()
    public ResponseResult insert(@RequestBody Category2 category2) {
        return ResponseResult.okResult(this.category2Service.save(category2));
    }

    /**
     * 修改数据
     *
     * @param category2 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody Category2 category2) {
        return ResponseResult.okResult(this.category2Service.updateById(category2));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return ResponseResult.okResult(this.category2Service.removeByIds(idList));
    }
}

