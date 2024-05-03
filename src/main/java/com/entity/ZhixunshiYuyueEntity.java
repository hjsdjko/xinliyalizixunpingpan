package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 咨询师预约
 *
 * @author 
 * @email
 */
@TableName("zhixunshi_yuyue")
public class ZhixunshiYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhixunshiYuyueEntity() {

	}

	public ZhixunshiYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 咨询师
     */
    @ColumnInfo(comment="咨询师",type="int(11)")
    @TableField(value = "zhixunshi_id")

    private Integer zhixunshiId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "zhixunshi_yuyue_time")

    private Date zhixunshiYuyueTime;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "zhixunshi_yuyue_text")

    private String zhixunshiYuyueText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ZhixunshiYuyue{" +
            ", id=" + id +
            ", zhixunshiId=" + zhixunshiId +
            ", zhixunshiYuyueTime=" + DateUtil.convertString(zhixunshiYuyueTime,"yyyy-MM-dd") +
            ", zhixunshiYuyueText=" + zhixunshiYuyueText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
