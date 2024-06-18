package org.lingge.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.lingge.domain.entity.Category2;
import org.lingge.domain.entity.Category3;

import java.util.List;


/**
 * (Category3)表服务接口
 *
 * @author makejava
 * @since 2024-05-28 22:55:19
 */
public interface Category3Service extends IService<Category3> {

    List<Category3> getAttr3(Category3 category3);
}
