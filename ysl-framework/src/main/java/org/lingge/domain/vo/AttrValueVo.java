package org.lingge.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttrValueVo {
    private Long id;

    //属性值
    private String valuename;
    //属性id
    private Long attrid;
}
