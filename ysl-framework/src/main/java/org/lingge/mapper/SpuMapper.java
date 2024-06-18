package org.lingge.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.lingge.domain.entity.Spu;


/**
 * (Spu)表数据库访问层
 *
 * @author makejava
 * @since 2024-06-17 13:30:54
 */
@Mapper
public interface SpuMapper extends BaseMapper<Spu> {

}
