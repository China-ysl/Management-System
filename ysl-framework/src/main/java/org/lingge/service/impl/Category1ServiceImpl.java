package org.lingge.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lingge.domain.entity.Category1;
import org.lingge.mapper.Category1Mapper;
import org.lingge.service.Category1Service;
import org.springframework.stereotype.Service;

/**
 * (Category1)表服务实现类
 *
 * @author makejava
 * @since 2024-05-27 15:09:39
 */
@Service("category1Service")
public class Category1ServiceImpl extends ServiceImpl<Category1Mapper, Category1> implements Category1Service {

}
