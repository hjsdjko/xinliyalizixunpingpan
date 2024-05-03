package com.entity.model;

import com.entity.ZhixunshiYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 咨询师预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhixunshiYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 咨询师
     */
    private Integer zhixunshiId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhixunshiYuyueTime;


    /**
     * 备注
     */
    private String zhixunshiYuyueText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：咨询师
	 */
    public Integer getZhixunshiId() {
        return zhixunshiId;
    }


    /**
	 * 设置：咨询师
	 */
    public void setZhixunshiId(Integer zhixunshiId) {
        this.zhixunshiId = zhixunshiId;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getZhixunshiYuyueTime() {
        return zhixunshiYuyueTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setZhixunshiYuyueTime(Date zhixunshiYuyueTime) {
        this.zhixunshiYuyueTime = zhixunshiYuyueTime;
    }
    /**
	 * 获取：备注
	 */
    public String getZhixunshiYuyueText() {
        return zhixunshiYuyueText;
    }


    /**
	 * 设置：备注
	 */
    public void setZhixunshiYuyueText(String zhixunshiYuyueText) {
        this.zhixunshiYuyueText = zhixunshiYuyueText;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
