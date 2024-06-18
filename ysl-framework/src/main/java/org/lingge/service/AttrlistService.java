package org.lingge.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.entity.Attrlist;
import org.lingge.domain.vo.AttrlistVo;

import java.util.List;


/**
 * (Attrlist)表服务接口
 *
 * @author makejava
 * @since 2024-05-29 19:27:47
 */
public interface AttrlistService extends IService<Attrlist> {

    ResponseResult getAttrListAll();

    ResponseResult<AttrlistVo> getAttrValueList(Long attr1id, Long attr2id, Long attr3id);


    ResponseResult<AttrlistVo> AttrListAdd(AttrlistVo attrList);

    boolean removeAttrList(Long listId);
}
