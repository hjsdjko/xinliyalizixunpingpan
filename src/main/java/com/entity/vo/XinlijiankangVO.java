package com.entity.vo;

import com.entity.XinlijiankangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 心理健康
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xinlijiankang")
public class XinlijiankangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 心理健康标题
     */

    @TableField(value = "xinlijiankang_name")
    private String xinlijiankangName;


    /**
     * 心理健康照片
     */

    @TableField(value = "xinlijiankang_photo")
    private String xinlijiankangPhoto;


    /**
     * 心理健康视频
     */

    @TableField(value = "xinlijiankang_video")
    private String xinlijiankangVideo;


    /**
     * 心理健康类型
     */

    @TableField(value = "xinlijiankang_types")
    private Integer xinlijiankangTypes;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 逻辑删除
     */

    @TableField(value = "xinlijiankang_delete")
    private Integer xinlijiankangDelete;


    /**
     * 心理健康详情
     */

    @TableField(value = "xinlijiankang_content")
    private String xinlijiankangContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：心理健康标题
	 */
    public String getXinlijiankangName() {
        return xinlijiankangName;
    }


    /**
	 * 获取：心理健康标题
	 */

    public void setXinlijiankangName(String xinlijiankangName) {
        this.xinlijiankangName = xinlijiankangName;
    }
    /**
	 * 设置：心理健康照片
	 */
    public String getXinlijiankangPhoto() {
        return xinlijiankangPhoto;
    }


    /**
	 * 获取：心理健康照片
	 */

    public void setXinlijiankangPhoto(String xinlijiankangPhoto) {
        this.xinlijiankangPhoto = xinlijiankangPhoto;
    }
    /**
	 * 设置：心理健康视频
	 */
    public String getXinlijiankangVideo() {
        return xinlijiankangVideo;
    }


    /**
	 * 获取：心理健康视频
	 */

    public void setXinlijiankangVideo(String xinlijiankangVideo) {
        this.xinlijiankangVideo = xinlijiankangVideo;
    }
    /**
	 * 设置：心理健康类型
	 */
    public Integer getXinlijiankangTypes() {
        return xinlijiankangTypes;
    }


    /**
	 * 获取：心理健康类型
	 */

    public void setXinlijiankangTypes(Integer xinlijiankangTypes) {
        this.xinlijiankangTypes = xinlijiankangTypes;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXinlijiankangDelete() {
        return xinlijiankangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXinlijiankangDelete(Integer xinlijiankangDelete) {
        this.xinlijiankangDelete = xinlijiankangDelete;
    }
    /**
	 * 设置：心理健康详情
	 */
    public String getXinlijiankangContent() {
        return xinlijiankangContent;
    }


    /**
	 * 获取：心理健康详情
	 */

    public void setXinlijiankangContent(String xinlijiankangContent) {
        this.xinlijiankangContent = xinlijiankangContent;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
