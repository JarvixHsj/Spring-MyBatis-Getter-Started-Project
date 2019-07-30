package cn.com.mybatis.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import cn.com.mybatis.datasource.DataConnection;
import cn.com.mybatis.po.User;
/**
 * This is Description
 *
 * @author Jarvix
 * @date 2019/07/07
 */
public class MyBatisTest {
    public DataConnection dataConn=new DataConnection();

    @Test
    public void TestSelect() throws IOException {
        SqlSession sqlSession=dataConn.getSqlSession();
        User user=sqlSession.selectOne("test.findUserById",1);
        System.out.println("姓名:"+user.getUsername());
        System.out.println("性别:"+user.getGender());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("生日:"+sdf.format(user.getBirthday()));
        System.out.println("所在地:"+user.getProvince()+user.getCity());
        sqlSession.close();
    }

    @Test
    public void TestFuzzySearch() throws IOException {
        SqlSession sqlSession=dataConn.getSqlSession();
        sqlSession.selectList("test.findUserByUsername","丽");
        User user=sqlSession.selectOne("test.findUserById",1);
        System.out.println("姓名:"+user.getUsername());
        System.out.println("性别:"+user.getGender());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("生日:"+sdf.format(user.getBirthday()));
        System.out.println("所在地:"+user.getProvince()+user.getCity());
        sqlSession.close();
    }
}
