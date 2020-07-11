package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.Customer;

/**
 * 客户Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-10
 */
public interface CustomerMapper 
{
    /**
     * 查询客户
     * 
     * @param userid 客户ID
     * @return 客户
     */
    public Customer selectCustomerById(Long userid);

    /**
     * 查询客户列表
     * 
     * @param customer 客户
     * @return 客户集合
     */
    public List<Customer> selectCustomerList(Customer customer);

    /**
     * 新增客户
     * 
     * @param customer 客户
     * @return 结果
     */
    public int insertCustomer(Customer customer);

    /**
     * 修改客户
     * 
     * @param customer 客户
     * @return 结果
     */
    public int updateCustomer(Customer customer);

    /**
     * 删除客户
     * 
     * @param userid 客户ID
     * @return 结果
     */
    public int deleteCustomerById(Long userid);

    /**
     * 批量删除客户
     * 
     * @param userids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCustomerByIds(Long[] userids);
}
