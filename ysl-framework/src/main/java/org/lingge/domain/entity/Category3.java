package org.lingge.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (Category3)表实体类
 *
 * @author makejava
 * @since 2024-05-28 22:55:18
 */
@SuppressWarnings("serial")
@Data
@TableName("sys_category3")
@AllArgsConstructor
@NoArgsConstructor
public class Category3 {
    //三级分类id@TableId
    private Long id;
    //三级分类名
    private String name;
    //二级分类id
    private Long category2id;
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

