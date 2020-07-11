package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.CustomerMapper;
import com.ruoyi.project.system.domain.Customer;
import com.ruoyi.project.system.service.ICustomerService;

/**
 * 客户Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-10
 */
@Service
public class CustomerServiceImpl implements ICustomerService 
{
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询客户
     * 
     * @param userid 客户ID
     * @return 客户
     */
    @Override
    public Customer selectCustomerById(Long userid)
    {
        return customerMapper.selectCustomerById(userid);
    }

    /**
     * 查询客户列表
     * 
     * @param customer 客户
     * @return 客户
     */
    @Override
    public List<Customer> selectCustomerList(Customer customer)
    {
        return customerMapper.selectCustomerList(customer);
    }

    /**
     * 新增客户
     * 
     * @param customer 客户
     * @return 结果
     */
    @Override
    public int insertCustomer(Customer customer)
    {
        return customerMapper.insertCustomer(customer);
    }

    /**
     * 修改客户
     * 
     * @param customer 客户
     * @return 结果
     */
    @Override
    public int updateCustomer(Customer customer)
    {
        return customerMapper.updateCustomer(customer);
    }

    /**
     * 批量删除客户
     * 
     * @param userids 需要删除的客户ID
     * @return 结果
     */
    @Override
    public int deleteCustomerByIds(Long[] userids)
    {
        return customerMapper.deleteCustomerByIds(userids);
    }

    /**
     * 删除客户信息
     * 
     * @param userid 客户ID
     * @return 结果
     */
    @Override
    public int deleteCustomerById(Long userid)
    {
        return customerMapper.deleteCustomerById(userid);
    }
}
