package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 客户对象 customer
 * 
 * @author ruoyi
 * @date 2020-07-10
 */
public class Customer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long userid;

    /** 姓名 */
    @Excel(name = "姓名")
    private String nickname;

    /** 电话 */
    @Excel(name = "电话")
    private String iphone;

    /** 所属行业 */
    @Excel(name = "所属行业")
    private String trade;

    /** 是否营业执照 */
    @Excel(name = "是否营业执照")
    private String business;

    /** 所在省 */
    @Excel(name = "所在省")
    private String province;

    /** 所在市 */
    @Excel(name = "所在市")
    private String city;

    /** 咨询产品 */
    @Excel(name = "咨询产品")
    private String products;

    /** 需求 */
    @Excel(name = "需求")
    private String ps;

    public void setUserid(Long userid) 
    {
        this.userid = userid;
    }

    public Long getUserid() 
    {
        return userid;
    }
    public void setNickname(String nickname) 
    {
        this.nickname = nickname;
    }

    public String getNickname() 
    {
        return nickname;
    }
    public void setIphone(String iphone) 
    {
        this.iphone = iphone;
    }

    public String getIphone() 
    {
        return iphone;
    }
    public void setTrade(String trade) 
    {
        this.trade = trade;
    }

    public String getTrade() 
    {
        return trade;
    }
    public void setBusiness(String business) 
    {
        this.business = business;
    }

    public String getBusiness() 
    {
        return business;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setProducts(String products) 
    {
        this.products = products;
    }

    public String getProducts() 
    {
        return products;
    }
    public void setPs(String ps) 
    {
        this.ps = ps;
    }

    public String getPs() 
    {
        return ps;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userid", getUserid())
            .append("nickname", getNickname())
            .append("iphone", getIphone())
            .append("trade", getTrade())
            .append("business", getBusiness())
            .append("province", getProvince())
            .append("city", getCity())
            .append("products", getProducts())
            .append("ps", getPs())
            .toString();
    }
}
