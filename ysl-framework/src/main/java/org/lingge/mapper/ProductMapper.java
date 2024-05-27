package org.lingge.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.lingge.domain.entity.Product;


/**
 * (Shopping)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-16 11:38:25
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
