package org.lingge.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lingge.domain.entity.Attrvalue;
import org.lingge.domain.vo.AttrValueVo;
import org.lingge.mapper.AttrvalueMapper;
import org.lingge.service.AttrvalueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Attrvalue)表服务实现类
 *
 * @author makejava
 * @since 2024-05-30 00:30:19
 */
@Service("attrvalueService")
public class AttrvalueServiceImpl extends ServiceImpl<AttrvalueMapper, Attrvalue> implements AttrvalueService {
}
