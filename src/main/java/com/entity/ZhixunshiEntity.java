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
 * 咨询师
 *
 * @author 
 * @email
 */
@TableName("zhixunshi")
public class ZhixunshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhixunshiEntity() {

	}

	public ZhixunshiEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 咨询师姓名
     */
    @ColumnInfo(comment="咨询师姓名",type="varchar(200)")
    @TableField(value = "zhixunshi_name")

    private String zhixunshiName;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 咨询师头像
     */
    @ColumnInfo(comment="咨询师头像",type="varchar(200)")
    @TableField(value = "zhixunshi_photo")

    private String zhixunshiPhoto;


    /**
     * 身份证号
     */
    @ColumnInfo(comment="身份证号",type="varchar(200)")
    @TableField(value = "zhixunshi_id_number")

    private String zhixunshiIdNumber;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "zhixunshi_phone")

    private String zhixunshiPhone;


    /**
     * 电子邮箱
     */
    @ColumnInfo(comment="电子邮箱",type="varchar(200)")
    @TableField(value = "zhixunshi_email")

    private String zhixunshiEmail;


    /**
     * 从业时长
     */
    @ColumnInfo(comment="从业时长",type="varchar(200)")
    @TableField(value = "zhixunshi_congye")

    private String zhixunshiCongye;


    /**
     * 擅长
     */
    @ColumnInfo(comment="擅长",type="varchar(200)")
    @TableField(value = "zhixunshi_shanchang")

    private String zhixunshiShanchang;


    /**
     * 个人简介
     */
    @ColumnInfo(comment="个人简介",type="text")
    @TableField(value = "zhixunshi_content")

    private String zhixunshiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "zhixunshi_delete")

    private Integer zhixunshiDelete;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：咨询师姓名
	 */
    public String getZhixunshiName() {
        return zhixunshiName;
    }
    /**
	 * 设置：咨询师姓名
	 */

    public void setZhixunshiName(String zhixunshiName) {
        this.zhixunshiName = zhixunshiName;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：咨询师头像
	 */
    public String getZhixunshiPhoto() {
        return zhixunshiPhoto;
    }
    /**
	 * 设置：咨询师头像
	 */

    public void setZhixunshiPhoto(String zhixunshiPhoto) {
        this.zhixunshiPhoto = zhixunshiPhoto;
    }
    /**
	 * 获取：身份证号
	 */
    public String getZhixunshiIdNumber() {
        return zhixunshiIdNumber;
    }
    /**
	 * 设置：身份证号
	 */

    public void setZhixunshiIdNumber(String zhixunshiIdNumber) {
        this.zhixunshiIdNumber = zhixunshiIdNumber;
    }
    /**
	 * 获取：联系方式
	 */
    public String getZhixunshiPhone() {
        return zhixunshiPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setZhixunshiPhone(String zhixunshiPhone) {
        this.zhixunshiPhone = zhixunshiPhone;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getZhixunshiEmail() {
        return zhixunshiEmail;
    }
    /**
	 * 设置：电子邮箱
	 */

    public void setZhixunshiEmail(String zhixunshiEmail) {
        this.zhixunshiEmail = zhixunshiEmail;
    }
    /**
	 * 获取：从业时长
	 */
    public String getZhixunshiCongye() {
        return zhixunshiCongye;
    }
    /**
	 * 设置：从业时长
	 */

    public void setZhixunshiCongye(String zhixunshiCongye) {
        this.zhixunshiCongye = zhixunshiCongye;
    }
    /**
	 * 获取：擅长
	 */
    public String getZhixunshiShanchang() {
        return zhixunshiShanchang;
    }
    /**
	 * 设置：擅长
	 */

    public void setZhixunshiShanchang(String zhixunshiShanchang) {
        this.zhixunshiShanchang = zhixunshiShanchang;
    }
    /**
	 * 获取：个人简介
	 */
    public String getZhixunshiContent() {
        return zhixunshiContent;
    }
    /**
	 * 设置：个人简介
	 */

    public void setZhixunshiContent(String zhixunshiContent) {
        this.zhixunshiContent = zhixunshiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getZhixunshiDelete() {
        return zhixunshiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setZhixunshiDelete(Integer zhixunshiDelete) {
        this.zhixunshiDelete = zhixunshiDelete;
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
        return "Zhixunshi{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", zhixunshiName=" + zhixunshiName +
            ", sexTypes=" + sexTypes +
            ", zhixunshiPhoto=" + zhixunshiPhoto +
            ", zhixunshiIdNumber=" + zhixunshiIdNumber +
            ", zhixunshiPhone=" + zhixunshiPhone +
            ", zhixunshiEmail=" + zhixunshiEmail +
            ", zhixunshiCongye=" + zhixunshiCongye +
            ", zhixunshiShanchang=" + zhixunshiShanchang +
            ", zhixunshiContent=" + zhixunshiContent +
            ", zhixunshiDelete=" + zhixunshiDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
