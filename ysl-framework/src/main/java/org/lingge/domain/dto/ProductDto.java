package org.lingge.domain.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@NoArgsConstructor//空参构造
@AllArgsConstructor//有参构造
@ToString
public class ProductDto {

    //品牌名称
    private String brandName;
    //品牌logo
    private String logoUrl;
    //启用状态 (0代表启用，1代表未启用)
    private String status;
    //创建人id
    private Long createBy;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //更新人
    private Long updateBy;
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
