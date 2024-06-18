package org.lingge.Controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.lingge.annotation.SystemLog;
import org.lingge.domain.ResponseResult;

import org.lingge.domain.entity.Attrlist;
import org.lingge.domain.vo.AttrlistVo;
import org.lingge.service.AttrlistService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Attrlist)表控制层
 *
 * @author makejava
 * @since 2024-05-29 19:27:46
 */
@RestController
@RequestMapping("/AttrList")
public class AttrlistController {
    /**
     * 服务对象
     */
    @Resource
    private AttrlistService attrlistService;
    /**
     * 查询attrList attrValue表返回数据
     * 根据attr1Id，attr2Id，attr3Id查询数据
     * @return 所有数据
     */
    @SystemLog(businessName = "AttrValueList接口")
    @GetMapping("/{AttrId1}/{AttrId2}/{AttrId3}")
    public  ResponseResult<AttrlistVo> getAttrValueList(@PathVariable(value = "AttrId1") Long attr1id, @PathVariable(value = "AttrId2") Long attr2id, @PathVariable(value = "AttrId3") Long attr3id){
        return this.attrlistService.getAttrValueList(attr1id,attr2id,attr3id);
    }
    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    @SystemLog(businessName = "查询所有AttrList接口")
    @GetMapping("/All")
    public ResponseResult getAll() {return this.attrlistService.getAttrListAll();}
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param attrlist 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Page<Attrlist> page, Attrlist attrlist) {
        return ResponseResult.okResult(this.attrlistService.page(page, new QueryWrapper<>(attrlist)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @SystemLog(businessName = "根据id查询对应AttrList接口")
    @GetMapping("/{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return ResponseResult.okResult(this.attrlistService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param attrlist 实体对象
     * @return 新增结果
     */
    @SystemLog(businessName = "新增AttrList接口")
    @PostMapping
    public ResponseResult insert(@RequestBody Attrlist attrlist) {
        return ResponseResult.okResult(this.attrlistService.save(attrlist));
    }

    @SystemLog(businessName = "新增AttrValueList接口")
    @PostMapping("/AttrListAdd")
    public ResponseResult batchAdd(@RequestBody AttrlistVo  attrList) {
        return attrlistService.AttrListAdd(attrList);
    }

    /**
     * 修改数据
     *
     * @param attrlist 实体对象
     * @return 修改结果
     */
    @SystemLog(businessName = "修改AttrList接口")
    @PutMapping
    public ResponseResult update(@RequestBody Attrlist attrlist) {
        return ResponseResult.okResult(this.attrlistService.updateById(attrlist));
    }

    /**
     * 删除数据
     *
     * @param listId 主键结合
     * @return 删除结果
     */
    @SystemLog(businessName = "删除AttrList和attrValue接口")
    @DeleteMapping
    public ResponseResult attrDelete(@RequestParam("listId") Long listId) {
        return ResponseResult.okResult(this.attrlistService.removeAttrList(listId));
    }
}

