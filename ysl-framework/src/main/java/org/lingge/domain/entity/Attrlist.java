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
 * (Attrlist)表实体类
 *
 * @author makejava
 * @since 2024-05-29 19:15:06
 */
@SuppressWarnings("serial")
@Data
@TableName("sys_attrlist")
@AllArgsConstructor
@NoArgsConstructor
public class Attrlist  {
    //id@TableId
    private Long id;

    //属性名
    private String attrname;
    //种类id
    private Long categoryid;
    //类别
    private String categorylevel;
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

