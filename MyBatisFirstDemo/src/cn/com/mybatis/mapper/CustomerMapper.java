package cn.com.mybatis.mapper;

import cn.com.mybatis.po.Customer;

public interface CustomerMapper {
    public Customer findCustomerById(int id) throws Exception;

    public void insertCustomer(Customer customer) throws Exception;

    public void updateCustomer(Customer customer) throws Exception;

    public void deleteCustomer(int id) throws Exception;
}
