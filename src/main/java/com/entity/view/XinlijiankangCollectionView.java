package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XinlijiankangCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 心理健康收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xinlijiankang_collection")
public class XinlijiankangCollectionView extends XinlijiankangCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String xinlijiankangCollectionValue;

	//级联表 心理健康
		/**
		* 心理健康标题
		*/

		@ColumnInfo(comment="心理健康标题",type="varchar(200)")
		private String xinlijiankangName;
		/**
		* 心理健康照片
		*/

		@ColumnInfo(comment="心理健康照片",type="varchar(200)")
		private String xinlijiankangPhoto;
		/**
		* 心理健康视频
		*/

		@ColumnInfo(comment="心理健康视频",type="varchar(200)")
		private String xinlijiankangVideo;
		/**
		* 心理健康类型
		*/
		@ColumnInfo(comment="心理健康类型",type="int(11)")
		private Integer xinlijiankangTypes;
			/**
			* 心理健康类型的值
			*/
			@ColumnInfo(comment="心理健康类型的字典表值",type="varchar(200)")
			private String xinlijiankangValue;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer xinlijiankangDelete;
		/**
		* 心理健康详情
		*/

		@ColumnInfo(comment="心理健康详情",type="text")
		private String xinlijiankangContent;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public XinlijiankangCollectionView() {

	}

	public XinlijiankangCollectionView(XinlijiankangCollectionEntity xinlijiankangCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, xinlijiankangCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getXinlijiankangCollectionValue() {
		return xinlijiankangCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setXinlijiankangCollectionValue(String xinlijiankangCollectionValue) {
		this.xinlijiankangCollectionValue = xinlijiankangCollectionValue;
	}


	//级联表的get和set 心理健康

		/**
		* 获取： 心理健康标题
		*/
		public String getXinlijiankangName() {
			return xinlijiankangName;
		}
		/**
		* 设置： 心理健康标题
		*/
		public void setXinlijiankangName(String xinlijiankangName) {
			this.xinlijiankangName = xinlijiankangName;
		}

		/**
		* 获取： 心理健康照片
		*/
		public String getXinlijiankangPhoto() {
			return xinlijiankangPhoto;
		}
		/**
		* 设置： 心理健康照片
		*/
		public void setXinlijiankangPhoto(String xinlijiankangPhoto) {
			this.xinlijiankangPhoto = xinlijiankangPhoto;
		}

		/**
		* 获取： 心理健康视频
		*/
		public String getXinlijiankangVideo() {
			return xinlijiankangVideo;
		}
		/**
		* 设置： 心理健康视频
		*/
		public void setXinlijiankangVideo(String xinlijiankangVideo) {
			this.xinlijiankangVideo = xinlijiankangVideo;
		}
		/**
		* 获取： 心理健康类型
		*/
		public Integer getXinlijiankangTypes() {
			return xinlijiankangTypes;
		}
		/**
		* 设置： 心理健康类型
		*/
		public void setXinlijiankangTypes(Integer xinlijiankangTypes) {
			this.xinlijiankangTypes = xinlijiankangTypes;
		}


			/**
			* 获取： 心理健康类型的值
			*/
			public String getXinlijiankangValue() {
				return xinlijiankangValue;
			}
			/**
			* 设置： 心理健康类型的值
			*/
			public void setXinlijiankangValue(String xinlijiankangValue) {
				this.xinlijiankangValue = xinlijiankangValue;
			}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getXinlijiankangDelete() {
			return xinlijiankangDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setXinlijiankangDelete(Integer xinlijiankangDelete) {
			this.xinlijiankangDelete = xinlijiankangDelete;
		}

		/**
		* 获取： 心理健康详情
		*/
		public String getXinlijiankangContent() {
			return xinlijiankangContent;
		}
		/**
		* 设置： 心理健康详情
		*/
		public void setXinlijiankangContent(String xinlijiankangContent) {
			this.xinlijiankangContent = xinlijiankangContent;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "XinlijiankangCollectionView{" +
			", xinlijiankangCollectionValue=" + xinlijiankangCollectionValue +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			", xinlijiankangName=" + xinlijiankangName +
			", xinlijiankangPhoto=" + xinlijiankangPhoto +
			", xinlijiankangVideo=" + xinlijiankangVideo +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", xinlijiankangDelete=" + xinlijiankangDelete +
			", xinlijiankangContent=" + xinlijiankangContent +
			"} " + super.toString();
	}
}
