package cn.com.mybatis.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import cn.com.mybatis.po.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import cn.com.mybatis.datasource.DataConnection;

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
        List<User> userList =  sqlSession.selectList("test.findUserByUsername","丽");
        for (int i = 0;i < userList.size(); i++) {
            User user = userList.get(i);
            System.out.println("姓名:"+user.getUsername());
            System.out.println("性别:"+user.getGender());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("生日:"+sdf.format(user.getBirthday()));
            System.out.println("所在地:"+user.getProvince()+user.getCity());
        }
        sqlSession.close();
    }

    @Test
    public void TestInsert() throws IOException, ParseException {
        SqlSession sqlSession = dataConn.getSqlSession();
        User user = new User();
        user.setUsername("孙佳佳");
        user.setGender("男");
        user.setEmail("5555@qq.com");
        user.setPassword("55555");
        user.setProvince("湖北省");
        user.setCity("武汉市");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        user.setBirthday(sdf.parse("1991-02-16"));
        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
        System.out.println(user.getId());
        sqlSession.close();
    }

    @Test
    public void TestUpdateUserName() throws IOException {
        SqlSession sqlSession = dataConn.getSqlSession();
        User user = new User();
        user.setId(7);
        user.setUsername("小善君");
        sqlSession.update("test.updateUserName",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestDelete() throws IOException{
        SqlSession sqlSession = dataConn.getSqlSession();
        sqlSession.delete("test.deleteUser",7);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindUserList() throws Exception{
        SqlSession session = dataConn.getSqlSession();
        UserQueryInfo userQueryInfo = new UserQueryInfo();
        UserInstance userInstance = new UserInstance();
        userInstance.setUsername("张三");
        userInstance.setGender("男");
        userQueryInfo.setUserInstance(userInstance);

        //调用mapper方法
        List<UserInstance> userList = session.selectList("test.findUserList",userQueryInfo);
        for (int i = 0; i < userList.size(); i++) {
            UserInstance user =  (UserInstance) userList.get(i);
            System.out.println(user.getId() + ":" + user.getUsername());
        }
        session.close();
    }

    @Test
    public void testFindBatchCustomer() throws Exception{
        SqlSession sqlSession = dataConn.getSqlSession();

        List<BatchCustomer> list = sqlSession.selectList("test.findBatchCustomer");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < list.size(); i++) {
            BatchCustomer batchCustomer = list.get(i);
            System.out.println("卡号为"+batchCustomer.getAcno()+"的名为"+ batchCustomer.getUsername()+"的客户：");
            System.out.println("于"+sdf.format(batchCustomer.getCreatetime())+"采购了批次号为"+batchCustomer.getNumber()+"的一批理财产品");
        }

        sqlSession.close();
    }

    @Test
    public void testFindBatchAndBatchDetail() throws Exception{
        SqlSession sqlSession = dataConn.getSqlSession();

        BatchItem batchItem = sqlSession.selectOne("test.findBatchAndBatchDetail");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Customer customer = batchItem.getCustomer();

        System.out.println("卡号为"+customer.getAcno()+"的名为"+ customer.getUsername()+"的客户：");
        System.out.println("于"+sdf.format(batchItem.getCreatetime())+"采购了批次号为"+batchItem.getNumber()+"的一批理财产品");

        List<BatchDetail> batchDetails = batchItem.getBatchDetails();
        for (int i = 0; i < batchDetails.size(); i++) {
            BatchDetail batchDetail = batchDetails.get(i);
            System.out.println("id为"+batchDetail.getProduct_id()+"的理财产品"+batchDetail.getProduct_num()+"份");
        }
        sqlSession.close();
    }
}
