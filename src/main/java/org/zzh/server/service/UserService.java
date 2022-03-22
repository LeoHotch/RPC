package org.zzh.server.service;

import org.zzh.domain.User;

/**
 * @author ：ZiHao Zhang
 * @date ：2022/3/22 10:06
 */
public interface UserService {
    /**
     * 根据id获取User信息
     * @param id 主键
     * @return User实体
     */
    User getById(Integer id);
}
