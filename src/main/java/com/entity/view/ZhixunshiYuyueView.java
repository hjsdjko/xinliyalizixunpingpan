package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhixunshiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 咨询师预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhixunshi_yuyue")
public class ZhixunshiYuyueView extends ZhixunshiYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 咨询师
		/**
		* 咨询师姓名
		*/

		@ColumnInfo(comment="咨询师姓名",type="varchar(200)")
		private String zhixunshiName;
		/**
		* 咨询师头像
		*/

		@ColumnInfo(comment="咨询师头像",type="varchar(200)")
		private String zhixunshiPhoto;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String zhixunshiIdNumber;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String zhixunshiPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String zhixunshiEmail;
		/**
		* 从业时长
		*/

		@ColumnInfo(comment="从业时长",type="varchar(200)")
		private String zhixunshiCongye;
		/**
		* 擅长
		*/

		@ColumnInfo(comment="擅长",type="varchar(200)")
		private String zhixunshiShanchang;
		/**
		* 个人简介
		*/

		@ColumnInfo(comment="个人简介",type="text")
		private String zhixunshiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer zhixunshiDelete;



	public ZhixunshiYuyueView() {

	}

	public ZhixunshiYuyueView(ZhixunshiYuyueEntity zhixunshiYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, zhixunshiYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 咨询师

		/**
		* 获取： 咨询师姓名
		*/
		public String getZhixunshiName() {
			return zhixunshiName;
		}
		/**
		* 设置： 咨询师姓名
		*/
		public void setZhixunshiName(String zhixunshiName) {
			this.zhixunshiName = zhixunshiName;
		}

		/**
		* 获取： 咨询师头像
		*/
		public String getZhixunshiPhoto() {
			return zhixunshiPhoto;
		}
		/**
		* 设置： 咨询师头像
		*/
		public void setZhixunshiPhoto(String zhixunshiPhoto) {
			this.zhixunshiPhoto = zhixunshiPhoto;
		}

		/**
		* 获取： 身份证号
		*/
		public String getZhixunshiIdNumber() {
			return zhixunshiIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setZhixunshiIdNumber(String zhixunshiIdNumber) {
			this.zhixunshiIdNumber = zhixunshiIdNumber;
		}

		/**
		* 获取： 联系方式
		*/
		public String getZhixunshiPhone() {
			return zhixunshiPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setZhixunshiPhone(String zhixunshiPhone) {
			this.zhixunshiPhone = zhixunshiPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getZhixunshiEmail() {
			return zhixunshiEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setZhixunshiEmail(String zhixunshiEmail) {
			this.zhixunshiEmail = zhixunshiEmail;
		}

		/**
		* 获取： 从业时长
		*/
		public String getZhixunshiCongye() {
			return zhixunshiCongye;
		}
		/**
		* 设置： 从业时长
		*/
		public void setZhixunshiCongye(String zhixunshiCongye) {
			this.zhixunshiCongye = zhixunshiCongye;
		}

		/**
		* 获取： 擅长
		*/
		public String getZhixunshiShanchang() {
			return zhixunshiShanchang;
		}
		/**
		* 设置： 擅长
		*/
		public void setZhixunshiShanchang(String zhixunshiShanchang) {
			this.zhixunshiShanchang = zhixunshiShanchang;
		}

		/**
		* 获取： 个人简介
		*/
		public String getZhixunshiContent() {
			return zhixunshiContent;
		}
		/**
		* 设置： 个人简介
		*/
		public void setZhixunshiContent(String zhixunshiContent) {
			this.zhixunshiContent = zhixunshiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getZhixunshiDelete() {
			return zhixunshiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setZhixunshiDelete(Integer zhixunshiDelete) {
			this.zhixunshiDelete = zhixunshiDelete;
		}


	@Override
	public String toString() {
		return "ZhixunshiYuyueView{" +
			", zhixunshiName=" + zhixunshiName +
			", zhixunshiPhoto=" + zhixunshiPhoto +
			", zhixunshiIdNumber=" + zhixunshiIdNumber +
			", zhixunshiPhone=" + zhixunshiPhone +
			", zhixunshiEmail=" + zhixunshiEmail +
			", zhixunshiCongye=" + zhixunshiCongye +
			", zhixunshiShanchang=" + zhixunshiShanchang +
			", zhixunshiContent=" + zhixunshiContent +
			", zhixunshiDelete=" + zhixunshiDelete +
			"} " + super.toString();
	}
}
