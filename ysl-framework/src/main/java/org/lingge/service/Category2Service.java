package org.lingge.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.lingge.domain.entity.Category2;
import org.lingge.domain.vo.Category2Vo;

import java.util.List;


/**
 * (Category2)表服务接口
 *
 * @author makejava
 * @since 2024-05-28 00:10:44
 */
public interface Category2Service extends IService<Category2> {

   List<Category2Vo> getAttr2(Category2 category2);
}
