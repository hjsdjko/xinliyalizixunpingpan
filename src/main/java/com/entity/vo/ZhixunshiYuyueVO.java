package com.entity.vo;

import com.entity.ZhixunshiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 咨询师预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhixunshi_yuyue")
public class ZhixunshiYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 咨询师
     */

    @TableField(value = "zhixunshi_id")
    private Integer zhixunshiId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zhixunshi_yuyue_time")
    private Date zhixunshiYuyueTime;


    /**
     * 备注
     */

    @TableField(value = "zhixunshi_yuyue_text")
    private String zhixunshiYuyueText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：咨询师
	 */
    public Integer getZhixunshiId() {
        return zhixunshiId;
    }


    /**
	 * 获取：咨询师
	 */

    public void setZhixunshiId(Integer zhixunshiId) {
        this.zhixunshiId = zhixunshiId;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getZhixunshiYuyueTime() {
        return zhixunshiYuyueTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setZhixunshiYuyueTime(Date zhixunshiYuyueTime) {
        this.zhixunshiYuyueTime = zhixunshiYuyueTime;
    }
    /**
	 * 设置：备注
	 */
    public String getZhixunshiYuyueText() {
        return zhixunshiYuyueText;
    }


    /**
	 * 获取：备注
	 */

    public void setZhixunshiYuyueText(String zhixunshiYuyueText) {
        this.zhixunshiYuyueText = zhixunshiYuyueText;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
