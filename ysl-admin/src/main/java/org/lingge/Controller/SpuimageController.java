package org.lingge.Controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.entity.Spuimage;
import org.lingge.domain.vo.SpuimageVo;
import org.lingge.service.SpuimageService;
import org.lingge.utils.BeanCopyUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Spuimage)表控制层
 *
 * @author makejava
 * @since 2024-06-19 18:02:14
 */
@RestController
@RequestMapping("/SpuImage")
public class SpuimageController{
    /**
     * 服务对象
     */
    @Resource
    private SpuimageService spuimageService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param spuimage 查询实体
     * @return 所有数据
     */
    @GetMapping
    public ResponseResult selectAll(Page<Spuimage> page, Spuimage spuimage) {
        Page<Spuimage> spuImgList = spuimageService.page(page, new QueryWrapper<>(spuimage));
        Page<SpuimageVo> spuimageVoPage = new Page<>();
        spuimageVoPage.setCurrent(spuImgList.getCurrent());
        spuimageVoPage.setSize(spuImgList.getSize());
        spuimageVoPage.setPages(spuImgList.getPages());
        spuimageVoPage.setTotal(spuImgList.getTotal());
        spuimageVoPage.setOrders(spuImgList.getOrders());
        spuimageVoPage.setRecords(BeanCopyUtils.copyList(spuImgList.getRecords(), SpuimageVo.class));
        return ResponseResult.okResult(spuimageVoPage);
    }
    /**
     * 查询所有数据
     *
     * @param page 分页对象
     * @param spuimage 查询实体
     * @return 所有数据
     */
    @GetMapping("/List")
    public ResponseResult selectAllList(Page<Spuimage> page, Spuimage spuimage) {
        Page<Spuimage> spuImgList = spuimageService.page(page, new QueryWrapper<>(spuimage));
        return ResponseResult.okResult(BeanCopyUtils.copyList(spuImgList.getRecords(), SpuimageVo.class));
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public ResponseResult selectOne(@PathVariable Serializable id) {
        return ResponseResult.okResult(this.spuimageService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param spuimage 实体对象
     * @return 新增结果
     */
    @PostMapping
    public ResponseResult insert(@RequestBody Spuimage spuimage) {

        return ResponseResult.okResult(this.spuimageService.save(spuimage));
    }

    /**
     * 修改数据
     *
     * @param spuimage 实体对象
     * @return 修改结果
     */
    @PutMapping
    public ResponseResult update(@RequestBody Spuimage spuimage) {
        return ResponseResult.okResult(this.spuimageService.updateById(spuimage));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public ResponseResult delete(@RequestParam("idList") List<Long> idList) {
        return ResponseResult.okResult(this.spuimageService.removeByIds(idList));
    }
}

