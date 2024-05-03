package com.entity.model;

import com.entity.ZhixunshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 咨询师
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhixunshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 咨询师姓名
     */
    private String zhixunshiName;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 咨询师头像
     */
    private String zhixunshiPhoto;


    /**
     * 身份证号
     */
    private String zhixunshiIdNumber;


    /**
     * 联系方式
     */
    private String zhixunshiPhone;


    /**
     * 电子邮箱
     */
    private String zhixunshiEmail;


    /**
     * 从业时长
     */
    private String zhixunshiCongye;


    /**
     * 擅长
     */
    private String zhixunshiShanchang;


    /**
     * 个人简介
     */
    private String zhixunshiContent;


    /**
     * 逻辑删除
     */
    private Integer zhixunshiDelete;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
