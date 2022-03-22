package org.zzh.server.serviceImpl;

import org.zzh.domain.User;
import org.zzh.server.service.UserService;

import java.util.Random;
import java.util.UUID;

/**
 * @author ：ZiHao Zhang
 * @date ：2022/3/22 10:07
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getById(Integer id) {
        Random random = new Random();
        System.out.println("远程调用，查询User信息");
        return User.builder()
                .id(id)
                .userName(UUID.randomUUID().toString())
                .sex(random.nextBoolean())
                .build();
    }
}
