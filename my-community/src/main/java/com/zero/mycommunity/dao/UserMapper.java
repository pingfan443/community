package com.zero.mycommunity.dao;


import com.zero.mycommunity.entity.User;
import org.apache.ibatis.annotations.Mapper;

//mybatis标识的注解
@Mapper
public interface UserMapper {
    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);
    //返回更新行数
    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);

}
