package com.entity.model;

import com.entity.XinlijiankangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 心理健康
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinlijiankangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 心理健康标题
     */
    private String xinlijiankangName;


    /**
     * 心理健康照片
     */
    private String xinlijiankangPhoto;


    /**
     * 心理健康视频
     */
    private String xinlijiankangVideo;


    /**
     * 心理健康类型
     */
    private Integer xinlijiankangTypes;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 逻辑删除
     */
    private Integer xinlijiankangDelete;


    /**
     * 心理健康详情
     */
    private String xinlijiankangContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
