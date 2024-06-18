package org.lingge.domain.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (Spu)表实体类
 *
 * @author makejava
 * @since 2024-06-17 13:30:52
 */
@SuppressWarnings("serial")
@Data
@TableName("sys_spu")
@AllArgsConstructor
@NoArgsConstructor
public class SpuVo {
    //id@TableId
    private Long id;
    //spu名称
    private String spuname;
    //spu描述
    private String description;
    //三级分类id
    private Long category3id;
    //每个spu品牌id
    private Long tmid;
}

