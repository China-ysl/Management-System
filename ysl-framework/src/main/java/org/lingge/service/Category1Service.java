package org.lingge.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.entity.Category1;


/**
 * (Category1)表服务接口
 *
 * @author makejava
 * @since 2024-05-27 14:12:43
 */
public interface Category1Service extends IService<Category1> {

    ResponseResult getAttr();
}
