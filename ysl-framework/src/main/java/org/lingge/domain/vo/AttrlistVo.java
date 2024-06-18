package org.lingge.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lingge.domain.entity.Attrvalue;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttrlistVo {
    //id@TableId
    private Long id;
    //属性名
    private String attrname;
    //种类id
    private Long categoryid;
    //类别
    private String categorylevel;
    @TableField(exist = false)
    private List<AttrValueVo> attrValueList;
}
