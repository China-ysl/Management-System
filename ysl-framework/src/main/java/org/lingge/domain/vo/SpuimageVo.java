package org.lingge.domain.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (Spuimage)表实体类
 *
 * @author makejava
 * @since 2024-06-19 18:02:15
 */
@SuppressWarnings("serial")
@Data
@TableName("sys_spuimage")
@AllArgsConstructor
@NoArgsConstructor
public class SpuimageVo {
    //id@TableId
    private Long id;

    //图片名称
    private String imgName;
    //spu图片地址
    private String imageUrl;
    //spuid
    private Long spuid;
}

