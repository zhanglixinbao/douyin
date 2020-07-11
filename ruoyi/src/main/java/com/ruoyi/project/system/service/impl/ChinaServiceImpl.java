package com.ruoyi.project.system.service.impl;

import com.ruoyi.project.system.domain.China;
import com.ruoyi.project.system.mapper.ChinaMapper;
import com.ruoyi.project.system.service.IChinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 省份Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-10
 */
@Service
public class ChinaServiceImpl implements IChinaService 
{
    @Autowired
    private ChinaMapper chinaMapper;

    /**
     * 查询省份
     * 
     * @param id 省份ID
     * @return 省份
     */
    @Override
    public China selectChinaById(Long id)
    {
        return chinaMapper.selectChinaById(id);
    }

    /**
     * 查询省份列表
     * 
     * @param china 省份
     * @return 省份
     */
    @Override
    public List<China> selectChinaList(China china)
    {
        return chinaMapper.selectChinaList(china);
    }

    /**
     * 新增省份
     * 
     * @param china 省份
     * @return 结果
     */
    @Override
    public int insertChina(China china)
    {
        return chinaMapper.insertChina(china);
    }

    /**
     * 修改省份
     * 
     * @param china 省份
     * @return 结果
     */
    @Override
    public int updateChina(China china)
    {
        return chinaMapper.updateChina(china);
    }

    /**
     * 批量删除省份
     * 
     * @param ids 需要删除的省份ID
     * @return 结果
     */
    @Override
    public int deleteChinaByIds(Long[] ids)
    {
        return chinaMapper.deleteChinaByIds(ids);
    }

    /**
     * 删除省份信息
     * 
     * @param id 省份ID
     * @return 结果
     */
    @Override
    public int deleteChinaById(Long id)
    {
        return chinaMapper.deleteChinaById(id);
    }
    /**
     * 查询省份列表
     *
     * @param china 省份
     * @return 省份集合
     */
    public List<China> getProvinceList(){
        return chinaMapper.getProvinceList();
    }
    /**
     * 查询省份列表
     *
     * @param china 省份
     * @return 省份集合
     */
    public List<China> getCity(China china){
        return chinaMapper.getCity(china);
    }
}
