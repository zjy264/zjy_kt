package com.example.lk_k.service.impl;

import com.example.lk_k.entity.User;
import com.example.lk_k.mapper.UserMapper;
import com.example.lk_k.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author write by zjy
 * @since 2020-08-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
