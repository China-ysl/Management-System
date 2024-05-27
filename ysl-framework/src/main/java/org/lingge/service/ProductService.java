package org.lingge.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.dto.ProductDto;
import org.lingge.domain.entity.Product;


/**
 * (Shopping)表服务接口
 *
 * @author makejava
 * @since 2024-05-16 11:38:24
 */
public interface ProductService extends IService<Product> {

    int getBrandlength();

    ResponseResult getAllBrand();

    ResponseResult<Product> getBrandPage(Integer pageNum, Integer pageSize, ProductDto shoppingdto);
}
