package com.ruoyi.project.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.China;
import com.ruoyi.project.system.service.IChinaService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 省份Controller
 * 
 * @author ruoyi
 * @date 2020-07-10
 */
@RestController
@RequestMapping("/system/china")
public class ChinaController extends BaseController
{
    @Autowired
    private IChinaService chinaService;

    /**
     * 查询省份列表
     */
    @PreAuthorize("@ss.hasPermi('system:china:list')")
    @GetMapping("/list")
    public TableDataInfo list(China china)
    {
        startPage();
        List<China> list = chinaService.selectChinaList(china);
        return getDataTable(list);
    }

    /**
     * 导出省份列表
     */
    @PreAuthorize("@ss.hasPermi('system:china:export')")
    @Log(title = "省份", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(China china)
    {
        List<China> list = chinaService.selectChinaList(china);
        ExcelUtil<China> util = new ExcelUtil<China>(China.class);
        return util.exportExcel(list, "china");
    }

    /**
     * 获取省份详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:china:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(chinaService.selectChinaById(id));
    }

    /**
     * 新增省份
     */
    @PreAuthorize("@ss.hasPermi('system:china:add')")
    @Log(title = "省份", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody China china)
    {
        return toAjax(chinaService.insertChina(china));
    }

    /**
     * 修改省份
     */
    @PreAuthorize("@ss.hasPermi('system:china:edit')")
    @Log(title = "省份", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody China china)
    {
        return toAjax(chinaService.updateChina(china));
    }

    /**
     * 删除省份
     */
    @PreAuthorize("@ss.hasPermi('system:china:remove')")
    @Log(title = "省份", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chinaService.deleteChinaByIds(ids));
    }
}
