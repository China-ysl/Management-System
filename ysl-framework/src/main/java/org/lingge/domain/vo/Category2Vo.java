package org.lingge.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category2Vo {
    private Long id;
    //二级分类名
    private String name;
    //一级分类id
    private Long category1id;
}
