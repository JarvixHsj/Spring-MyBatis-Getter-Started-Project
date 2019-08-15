package cn.com.mybatis.test;

import cn.com.mybatis.datasource.DataConnection;
import cn.com.mybatis.mapper.CustomerMapper;
import cn.com.mybatis.po.Customer;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created By xiaoweiping 2019/8/15 16:57
 **/
public class testCustomerMapper {

    public DataConnection dataConnection = new DataConnection();

    @Test
    public void testFindCustomerById() throws Exception{
        SqlSession sqlSession = dataConnection.getSqlSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer  = customerMapper.findCustomerById(1);
        System.out.println("用户姓名：" + customer.getUsername() + "，卡号："+ customer.getAcno());

        sqlSession.close();
    }

    @Test
    public void testFindCustomerByIdCache1() throws Exception{
        SqlSession sqlSession = dataConnection.getSqlSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer1 = customerMapper.findCustomerById(1);
        System.out.println("用户名："+customer1.getUsername());

        Customer customer2 = customerMapper.findCustomerById(1);
        System.out.println("用户名："+customer2.getUsername());

        sqlSession.close();
    }
}
