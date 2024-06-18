package org.lingge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lingge.constants.SystemConstants;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.entity.Attrlist;

import org.lingge.domain.entity.Attrvalue;
import org.lingge.domain.vo.AttrValueVo;
import org.lingge.domain.vo.AttrlistVo;
import org.lingge.domain.vo.MenuVo;
import org.lingge.mapper.AttrlistMapper;
import org.lingge.service.AttrlistService;
import org.lingge.service.AttrvalueService;
import org.lingge.utils.BeanCopyUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Attrlist)表服务实现类
 *
 * @author makejava
 * @since 2024-05-29 19:27:48
 */
@Service("attrlistService")
public class AttrlistServiceImpl extends ServiceImpl<AttrlistMapper, Attrlist> implements AttrlistService {
    @Lazy
    @Resource
    private AttrvalueService attrvalueService;
    @Lazy
    @Resource
    private AttrlistService attrlistService;

    @Override
    public ResponseResult getAttrListAll() {
        LambdaQueryWrapper<Attrlist> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Attrlist::getDelFlag, SystemConstants.NORMAL_USE);
        List<Attrlist> List = list(queryWrapper);
//        转化vo
        List<Attrlist> attrlist = BeanCopyUtils.copyList(List, Attrlist.class);
//        封装返回
        return ResponseResult.okResult(attrlist);
    }

    //    根据id查询属性名称和值
    @Override
    public ResponseResult<AttrlistVo> getAttrValueList(Long attr1id, Long attr2id, Long attr3id) {
        LambdaQueryWrapper<Attrlist> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attrlist::getCategoryid, attr3id);
        List<Attrlist> attrList = attrlistService.list(wrapper);
        List<AttrlistVo> attrListVos = BeanCopyUtils.copyList(attrList, AttrlistVo.class);
        //遍历vo
        attrListVos.stream().map(attrlistVo -> {
            LambdaQueryWrapper<Attrvalue> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Attrvalue::getAttrid, attrlistVo.getId());

            attrlistVo.setAttrValueList(BeanCopyUtils.copyList(attrvalueService.list(queryWrapper), AttrValueVo.class));
            return attrlistVo;
        }).collect(Collectors.toList());
        // 根据attrList的id查询attrValue的值

        return ResponseResult.okResult(attrListVos);
    }

//    更新attrList接口
    @Override
    @Transactional
    public ResponseResult<AttrlistVo> AttrListAdd(AttrlistVo attrList) {
        List<Attrvalue> valueList = BeanCopyUtils.copyList(attrList.getAttrValueList(), Attrvalue.class);
        Attrlist attrlist = BeanCopyUtils.copyBean(attrList, Attrlist.class);
        if (attrList.getId() != null) {
//            有id
            boolean b = attrlistService.updateById(attrlist);
            if (b == true) {
                for (int i = 0; i < valueList.size(); i++) {
                    Attrvalue attrvalue = valueList.get(i);
                   attrvalueService.saveOrUpdate(attrvalue);
                }
                return ResponseResult.okResult("更新成功");
            } else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseResult.okResult("更新失败");
            }
        } else {
            //       没有id
            boolean save = attrlistService.save(attrlist);
            if (save == true) {
                LambdaQueryWrapper<Attrlist> wrapper = new LambdaQueryWrapper<>();
                wrapper.eq(Attrlist::getAttrname, attrlist.getAttrname());
                boolean attrlistboolean = true;
                Attrlist one = attrlistService.getOne(wrapper, attrlistboolean);
                Long attrListId = one.getId();
                valueList.stream().forEach(attrvalue1 -> {
                    attrvalue1.setAttrid(attrListId);
                });
                boolean b = attrvalueService.saveBatch(valueList);
                if (b == true) {
                    return ResponseResult.okResult("AttrValue值插入成功");
                }else {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    ResponseResult.errorResult(501, "AttrValue值插入失败");
                }
            } else {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseResult.errorResult(501, "AttrList值插入失败");
            }
            return ResponseResult.okResult();
        }
    }

    @Override
    @Transactional
    public boolean removeAttrList(Long listId) {
        boolean listRemove = attrlistService.removeById(listId);
        LambdaQueryWrapper<Attrvalue> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attrvalue::getAttrid,listId);
        boolean valueRemove = attrvalueService.remove(wrapper);
        if (listRemove == true && valueRemove == true){
            return true;
        }else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }
//    根据attrListId删除对应属性名称和值
}
