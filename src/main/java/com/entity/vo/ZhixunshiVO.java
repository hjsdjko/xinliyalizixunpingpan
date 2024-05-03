package com.entity.vo;

import com.entity.ZhixunshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 咨询师
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhixunshi")
public class ZhixunshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 咨询师姓名
     */

    @TableField(value = "zhixunshi_name")
    private String zhixunshiName;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 咨询师头像
     */

    @TableField(value = "zhixunshi_photo")
    private String zhixunshiPhoto;


    /**
     * 身份证号
     */

    @TableField(value = "zhixunshi_id_number")
    private String zhixunshiIdNumber;


    /**
     * 联系方式
     */

    @TableField(value = "zhixunshi_phone")
    private String zhixunshiPhone;


    /**
     * 电子邮箱
     */

    @TableField(value = "zhixunshi_email")
    private String zhixunshiEmail;


    /**
     * 从业时长
     */

    @TableField(value = "zhixunshi_congye")
    private String zhixunshiCongye;


    /**
     * 擅长
     */

    @TableField(value = "zhixunshi_shanchang")
    private String zhixunshiShanchang;


    /**
     * 个人简介
     */

    @TableField(value = "zhixunshi_content")
    private String zhixunshiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "zhixunshi_delete")
    private Integer zhixunshiDelete;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：咨询师姓名
	 */
    public String getZhixunshiName() {
        return zhixunshiName;
    }


    /**
	 * 获取：咨询师姓名
	 */

    public void setZhixunshiName(String zhixunshiName) {
        this.zhixunshiName = zhixunshiName;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：咨询师头像
	 */
    public String getZhixunshiPhoto() {
        return zhixunshiPhoto;
    }


    /**
	 * 获取：咨询师头像
	 */

    public void setZhixunshiPhoto(String zhixunshiPhoto) {
        this.zhixunshiPhoto = zhixunshiPhoto;
    }
    /**
	 * 设置：身份证号
	 */
    public String getZhixunshiIdNumber() {
        return zhixunshiIdNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setZhixunshiIdNumber(String zhixunshiIdNumber) {
        this.zhixunshiIdNumber = zhixunshiIdNumber;
    }
    /**
	 * 设置：联系方式
	 */
    public String getZhixunshiPhone() {
        return zhixunshiPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setZhixunshiPhone(String zhixunshiPhone) {
        this.zhixunshiPhone = zhixunshiPhone;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getZhixunshiEmail() {
        return zhixunshiEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setZhixunshiEmail(String zhixunshiEmail) {
        this.zhixunshiEmail = zhixunshiEmail;
    }
    /**
	 * 设置：从业时长
	 */
    public String getZhixunshiCongye() {
        return zhixunshiCongye;
    }


    /**
	 * 获取：从业时长
	 */

    public void setZhixunshiCongye(String zhixunshiCongye) {
        this.zhixunshiCongye = zhixunshiCongye;
    }
    /**
	 * 设置：擅长
	 */
    public String getZhixunshiShanchang() {
        return zhixunshiShanchang;
    }


    /**
	 * 获取：擅长
	 */

    public void setZhixunshiShanchang(String zhixunshiShanchang) {
        this.zhixunshiShanchang = zhixunshiShanchang;
    }
    /**
	 * 设置：个人简介
	 */
    public String getZhixunshiContent() {
        return zhixunshiContent;
    }


    /**
	 * 获取：个人简介
	 */

    public void setZhixunshiContent(String zhixunshiContent) {
        this.zhixunshiContent = zhixunshiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getZhixunshiDelete() {
        return zhixunshiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setZhixunshiDelete(Integer zhixunshiDelete) {
        this.zhixunshiDelete = zhixunshiDelete;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
