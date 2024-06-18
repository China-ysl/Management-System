package org.lingge.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lingge.constants.SystemConstants;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.dto.ProductDto;
import org.lingge.domain.entity.Product;
import org.lingge.domain.vo.ProductVo;
import org.lingge.mapper.ProductMapper;
import org.lingge.service.ProductService;
import org.lingge.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * (Shopping)表服务实现类
 *
 * @author makejava
 * @since 2024-05-16 11:38:24
 */
@Service("shoppingService")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
//    Brand查询长度
    @Override
    public int getBrandlength(){
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Product::getDelFlag, SystemConstants.NORMAL_USE);
        List<Product> List = list(queryWrapper);
        return List.size();
    }

//    查询所有品牌信息
    @Override
    public ResponseResult getAllBrand() {
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Product::getDelFlag, SystemConstants.NORMAL_USE);
        List<Product> List = list(queryWrapper);
//        转化vo
        List<Product> brandList = BeanCopyUtils.copyList(List, Product.class);
//        封装返回
        return ResponseResult.okResult(brandList);
    }
//    System-分页查询品牌
    @Override
    public ResponseResult<Product> getBrandPage(Integer pageNum, Integer pageSize, ProductDto productdto) {

        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.like(StringUtils.hasText(productdto.getBrandName()),Product::getBrandName,productdto.getBrandName());

        queryWrapper.eq(Objects.nonNull(productdto.getStatus()), Product::getStatus, productdto.getStatus());

        Page<Product> page = new Page<>();

        page.setCurrent(pageNum);

        page.setSize(pageSize);

        page(page,queryWrapper);

        List<Product> shoppingList = page.getRecords();


        if (productdto.getBrandName() == ""){
            ProductVo ProductVo = new ProductVo(getBrandlength(),shoppingList);
            return ResponseResult.okResult(ProductVo);
        }else {
            ProductVo ProductVo = new ProductVo(shoppingList.size(),shoppingList);
            return ResponseResult.okResult(ProductVo);
        }
    }
}
