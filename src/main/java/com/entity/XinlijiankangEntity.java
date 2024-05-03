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
 * 心理健康
 *
 * @author 
 * @email
 */
@TableName("xinlijiankang")
public class XinlijiankangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinlijiankangEntity() {

	}

	public XinlijiankangEntity(T t) {
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
     * 心理健康标题
     */
    @ColumnInfo(comment="心理健康标题",type="varchar(200)")
    @TableField(value = "xinlijiankang_name")

    private String xinlijiankangName;


    /**
     * 心理健康照片
     */
    @ColumnInfo(comment="心理健康照片",type="varchar(200)")
    @TableField(value = "xinlijiankang_photo")

    private String xinlijiankangPhoto;


    /**
     * 心理健康视频
     */
    @ColumnInfo(comment="心理健康视频",type="varchar(200)")
    @TableField(value = "xinlijiankang_video")

    private String xinlijiankangVideo;


    /**
     * 心理健康类型
     */
    @ColumnInfo(comment="心理健康类型",type="int(11)")
    @TableField(value = "xinlijiankang_types")

    private Integer xinlijiankangTypes;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "xinlijiankang_delete")

    private Integer xinlijiankangDelete;


    /**
     * 心理健康详情
     */
    @ColumnInfo(comment="心理健康详情",type="text")
    @TableField(value = "xinlijiankang_content")

    private String xinlijiankangContent;


    /**
     * 创建时间
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
	 * 获取：心理健康标题
	 */
    public String getXinlijiankangName() {
        return xinlijiankangName;
    }
    /**
	 * 设置：心理健康标题
	 */

    public void setXinlijiankangName(String xinlijiankangName) {
        this.xinlijiankangName = xinlijiankangName;
    }
    /**
	 * 获取：心理健康照片
	 */
    public String getXinlijiankangPhoto() {
        return xinlijiankangPhoto;
    }
    /**
	 * 设置：心理健康照片
	 */

    public void setXinlijiankangPhoto(String xinlijiankangPhoto) {
        this.xinlijiankangPhoto = xinlijiankangPhoto;
    }
    /**
	 * 获取：心理健康视频
	 */
    public String getXinlijiankangVideo() {
        return xinlijiankangVideo;
    }
    /**
	 * 设置：心理健康视频
	 */

    public void setXinlijiankangVideo(String xinlijiankangVideo) {
        this.xinlijiankangVideo = xinlijiankangVideo;
    }
    /**
	 * 获取：心理健康类型
	 */
    public Integer getXinlijiankangTypes() {
        return xinlijiankangTypes;
    }
    /**
	 * 设置：心理健康类型
	 */

    public void setXinlijiankangTypes(Integer xinlijiankangTypes) {
        this.xinlijiankangTypes = xinlijiankangTypes;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXinlijiankangDelete() {
        return xinlijiankangDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setXinlijiankangDelete(Integer xinlijiankangDelete) {
        this.xinlijiankangDelete = xinlijiankangDelete;
    }
    /**
	 * 获取：心理健康详情
	 */
    public String getXinlijiankangContent() {
        return xinlijiankangContent;
    }
    /**
	 * 设置：心理健康详情
	 */

    public void setXinlijiankangContent(String xinlijiankangContent) {
        this.xinlijiankangContent = xinlijiankangContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xinlijiankang{" +
            ", id=" + id +
            ", xinlijiankangName=" + xinlijiankangName +
            ", xinlijiankangPhoto=" + xinlijiankangPhoto +
            ", xinlijiankangVideo=" + xinlijiankangVideo +
            ", xinlijiankangTypes=" + xinlijiankangTypes +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", xinlijiankangDelete=" + xinlijiankangDelete +
            ", xinlijiankangContent=" + xinlijiankangContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
