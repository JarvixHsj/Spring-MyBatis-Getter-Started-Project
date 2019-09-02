package cn.com.sm.mapper;

import cn.com.sm.po.User;

/**
 * Created By xiaoweiping 2019/9/2 15:27
 **/
public interface UserQueryMapper {

    public User findUserById(int id) throws Exception;
}
