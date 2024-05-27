package org.lingge.domain.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Shopping)表实体类
 *
 * @author makejava
 * @since 2024-05-16 18:26:12
 */
@Data
@TableName("sys_product")
@AllArgsConstructor
@NoArgsConstructor
public class Product  {
    //id主键@TableId
    private Long id;

    //品牌名称
    private String brandName;
    //品牌logo
    private String logoUrl;
    //启用状态 (0代表启用，1代表未启用)
    private String status;
    //创建人的用户id
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //更新人
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;


}

