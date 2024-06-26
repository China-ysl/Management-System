package org.lingge.Controller;
import org.lingge.annotation.SystemLog;
import org.lingge.domain.ResponseResult;
import org.lingge.domain.dto.ProductDto;
import org.lingge.domain.entity.Product;
import org.lingge.enums.AppHttpCodeEnum;
import org.lingge.exception.SystemException;
import org.lingge.service.ProductService;
import org.lingge.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Shopping")
public class ProductController {
    @Autowired
    private ProductService shoppingService ;
    @SystemLog(businessName = "System-查询所有品牌接口")
    @GetMapping("/getBrand")
    public ResponseResult  getAllBrand(){
        return  shoppingService.getAllBrand();
    }
    @SystemLog(businessName = "System-分页查询品牌接口")
    @GetMapping("/getBrandPage")
    public ResponseResult<Product>  getBrandPage(Integer pageNum, Integer pageSize, ProductDto productdto){
        return  shoppingService.getBrandPage(pageNum, pageSize,productdto);
    }
    @SystemLog(businessName = "System-品牌添加修改接口")
    @PutMapping
    public ResponseResult addUpdate(@RequestBody  Product product){
        if (!StringUtils.hasText(product.getBrandName()) || !StringUtils.hasText(product.getLogoUrl())){
            throw new SystemException(AppHttpCodeEnum.LOGO_BRAND);
        }else {
            shoppingService.saveOrUpdate(product);
        }
        return ResponseResult.okResult();
    }
    @SystemLog(businessName = "System-品牌删除接口")
    @DeleteMapping("/{id}")
    public ResponseResult Delete(@PathVariable(value = "id")  Long id){
        shoppingService.removeById(id);
        return ResponseResult.okResult();
    }
    //上传品牌logo接口
    @PostMapping("/img")
    public ResponseResult img (){
        return ResponseResult.okResult("https://cdn.cnbj1.fds.api.mi-img.com/mi.com-assets/shop/img/logo-mi2.png");
    }
}

