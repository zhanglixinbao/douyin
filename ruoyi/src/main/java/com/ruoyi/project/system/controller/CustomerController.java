package com.ruoyi.project.system.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.Customer;
import com.ruoyi.project.system.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 客户Controller
 * 
 * @author ruoyi
 * @date 2020-07-10
 */
@RestController
@RequestMapping("/system/customer")
public class CustomerController extends BaseController
{
    @Autowired
    private ICustomerService customerService;

    /**
     * 查询客户列表
     */
    @PreAuthorize("@ss.hasPermi('system:customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(Customer customer)
    {
        startPage();
        List<Customer> list = customerService.selectCustomerList(customer);
        return getDataTable(list);
    }

    /**
     * 导出客户列表
     */
    @PreAuthorize("@ss.hasPermi('system:customer:export')")
    @Log(title = "客户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Customer customer)
    {
        List<Customer> list = customerService.selectCustomerList(customer);
        ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
        return util.exportExcel(list, "customer");
    }

    /**
     * 获取客户详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:customer:query')")
    @GetMapping(value = "/{userid}")
    public AjaxResult getInfo(@PathVariable("userid") Long userid)
    {
        return AjaxResult.success(customerService.selectCustomerById(userid));
    }

    /**
     * 新增客户
     */
    @PreAuthorize("@ss.hasPermi('system:customer:add')")
    @Log(title = "客户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Customer customer)
    {
        return toAjax(customerService.insertCustomer(customer));
    }

    /**
     * 修改客户
     */
    @PreAuthorize("@ss.hasPermi('system:customer:edit')")
    @Log(title = "客户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Customer customer)
    {
        return toAjax(customerService.updateCustomer(customer));
    }

    /**
     * 删除客户
     */
    @PreAuthorize("@ss.hasPermi('system:customer:remove')")
    @Log(title = "客户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userids}")
    public AjaxResult remove(@PathVariable Long[] userids)
    {
        return toAjax(customerService.deleteCustomerByIds(userids));
    }
}
