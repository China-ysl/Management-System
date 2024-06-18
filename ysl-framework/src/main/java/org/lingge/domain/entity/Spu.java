package org.lingge.domain.entity;

import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class Spu  {
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

