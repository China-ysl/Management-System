package org.lingge.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (Category2)表实体类
 *
 * @author makejava
 * @since 2024-05-28 00:10:43
 */
@SuppressWarnings("serial")
@Data
@TableName("sys_category2")
@AllArgsConstructor
@NoArgsConstructor
public class Category2 {
    //二级分类id@TableId
    private Long id;
    //二级分类名
    private String name;
    //一级分类id
    private Long category1id;
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

