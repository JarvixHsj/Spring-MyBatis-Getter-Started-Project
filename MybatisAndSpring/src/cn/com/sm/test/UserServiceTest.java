package cn.com.sm.test;

import cn.com.sm.dao.UserDao;
import cn.com.sm.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created By xiaoweiping 2019/8/27 16:47
 **/
public class UserServiceTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() throws  Exception{
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception{
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = userDao.findUserById(1);
        System.out.println(user.getId() + ":" + user.getUsername());
    }
}
