package org.lingge.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product2Vo {

    //id主键@TableId
    private Long id;

    //品牌名称
    private String brandName;
    //品牌logo
    private String logoUrl;
}
