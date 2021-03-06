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

    /**
     * 测试一级缓存，第二次会直接从一级缓存中读取
     * @throws Exception
     */
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

    @Test
    public void testFindCustomerByIdCache2() throws Exception{
        SqlSession sqlSession = dataConnection.getSqlSession();

        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        customerMapper.findCustomerById(1);
        Customer customer1 = customerMapper.findCustomerById(1);
        System.out.println("用户名："+customer1.getUsername()+ "|卡号："+customer1.getAcno());

        String acno = "622828111111";
        Customer customer = new Customer();
        customer.setAcno(acno);
        customer.setCus_id(1);
        System.out.println("修改卡号为："+acno);
        customerMapper.updateCustomer(customer);

        Customer customer2 = customerMapper.findCustomerById(1);
        System.out.println("用户名："+customer2.getUsername()+ "|卡号："+customer2.getAcno());

        sqlSession.close();
    }

    @Test
    public void testFindCustomerOnMapper2() throws Exception{
        SqlSession sqlSession = dataConnection.getSqlSession();

        CustomerMapper customerMapper1 = sqlSession.getMapper(CustomerMapper.class);
        Customer customer1 = customerMapper1.findCustomerById(1);
        System.out.println("用户名："+customer1.getUsername()+ "|卡号："+customer1.getAcno());

        CustomerMapper customerMapper2 = sqlSession.getMapper(CustomerMapper.class);
        Customer customer2 = customerMapper2.findCustomerById(1);
        System.out.println("用户名："+customer2.getUsername()+ "|卡号："+customer2.getAcno());

        sqlSession.close();
    }
}
