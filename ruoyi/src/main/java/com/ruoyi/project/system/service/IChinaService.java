package com.ruoyi.project.system.service;

import com.ruoyi.project.system.domain.China;

import java.util.List;

/**
 * 省份Service接口
 * 
 * @author ruoyi
 * @date 2020-07-10
 */
public interface IChinaService 
{
    /**
     * 查询省份
     * 
     * @param id 省份ID
     * @return 省份
     */
    public China selectChinaById(Long id);

    /**
     * 查询省份列表
     * 
     * @param china 省份
     * @return 省份集合
     */
    public List<China> selectChinaList(China china);

    /**
     * 新增省份
     * 
     * @param china 省份
     * @return 结果
     */
    public int insertChina(China china);

    /**
     * 修改省份
     * 
     * @param china 省份
     * @return 结果
     */
    public int updateChina(China china);

    /**
     * 批量删除省份
     * 
     * @param ids 需要删除的省份ID
     * @return 结果
     */
    public int deleteChinaByIds(Long[] ids);

    /**
     * 删除省份信息
     * 
     * @param id 省份ID
     * @return 结果
     */
    public int deleteChinaById(Long id);
    /**
     * 查询省份列表
     *
     * @param china 省份
     * @return 省份集合
     */
    public List<China> getProvinceList();
    /**
     * 查询省份列表
     *
     * @param china 省份
     * @return 省份集合
     */
    public List<China> getCity(China china);


}
