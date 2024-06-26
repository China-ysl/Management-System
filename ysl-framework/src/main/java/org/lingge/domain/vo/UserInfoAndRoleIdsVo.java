package org.lingge.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lingge.domain.entity.Role;
import org.lingge.domain.entity.User;

import java.util.List;

/**
 * 标签(Tag)表实体类
 *
 * @author makejava
 * @since 2022-07-19 22:33:36
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoAndRoleIdsVo {
    private User user;
    private List<Role> roles;
    private List<Long> roleIds;



}
