package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ExamredetailsEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 答题详情表
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("examredetails")
public class ExamredetailsView extends ExamredetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 题目表
		/**
		* 题目名称
		*/

		@ColumnInfo(comment="题目名称",type="varchar(200)")
		private String examquestionName;
		/**
		* 选项，json字符串
		*/

		@ColumnInfo(comment="选项，json字符串",type="longtext")
		private String examquestionOptions;
		/**
		* 正确答案
		*/

		@ColumnInfo(comment="正确答案",type="varchar(200)")
		private String examquestionAnswer;
		/**
		* 答案解析
		*/

		@ColumnInfo(comment="答案解析",type="longtext")
		private String examquestionAnalysis;
		/**
		* 题目类型
		*/
		@ColumnInfo(comment="题目类型",type="int(20)")
		private Integer examquestionTypes;
			/**
			* 题目类型的值
			*/
			@ColumnInfo(comment="题目类型的字典表值",type="varchar(200)")
			private String examquestionValue;
		/**
		* 题目排序，值越大排越前面
		*/

		@ColumnInfo(comment="题目排序，值越大排越前面",type="int(20)")
		private Integer examquestionSequence;
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



	public ExamredetailsView() {

	}

	public ExamredetailsView(ExamredetailsEntity examredetailsEntity) {
		try {
			BeanUtils.copyProperties(this, examredetailsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 题目表

		/**
		* 获取： 题目名称
		*/
		public String getExamquestionName() {
			return examquestionName;
		}
		/**
		* 设置： 题目名称
		*/
		public void setExamquestionName(String examquestionName) {
			this.examquestionName = examquestionName;
		}

		/**
		* 获取： 选项，json字符串
		*/
		public String getExamquestionOptions() {
			return examquestionOptions;
		}
		/**
		* 设置： 选项，json字符串
		*/
		public void setExamquestionOptions(String examquestionOptions) {
			this.examquestionOptions = examquestionOptions;
		}

		/**
		* 获取： 正确答案
		*/
		public String getExamquestionAnswer() {
			return examquestionAnswer;
		}
		/**
		* 设置： 正确答案
		*/
		public void setExamquestionAnswer(String examquestionAnswer) {
			this.examquestionAnswer = examquestionAnswer;
		}

		/**
		* 获取： 答案解析
		*/
		public String getExamquestionAnalysis() {
			return examquestionAnalysis;
		}
		/**
		* 设置： 答案解析
		*/
		public void setExamquestionAnalysis(String examquestionAnalysis) {
			this.examquestionAnalysis = examquestionAnalysis;
		}
		/**
		* 获取： 题目类型
		*/
		public Integer getExamquestionTypes() {
			return examquestionTypes;
		}
		/**
		* 设置： 题目类型
		*/
		public void setExamquestionTypes(Integer examquestionTypes) {
			this.examquestionTypes = examquestionTypes;
		}


			/**
			* 获取： 题目类型的值
			*/
			public String getExamquestionValue() {
				return examquestionValue;
			}
			/**
			* 设置： 题目类型的值
			*/
			public void setExamquestionValue(String examquestionValue) {
				this.examquestionValue = examquestionValue;
			}

		/**
		* 获取： 题目排序，值越大排越前面
		*/
		public Integer getExamquestionSequence() {
			return examquestionSequence;
		}
		/**
		* 设置： 题目排序，值越大排越前面
		*/
		public void setExamquestionSequence(Integer examquestionSequence) {
			this.examquestionSequence = examquestionSequence;
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
		return "ExamredetailsView{" +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			", examquestionName=" + examquestionName +
			", examquestionOptions=" + examquestionOptions +
			", examquestionAnswer=" + examquestionAnswer +
			", examquestionAnalysis=" + examquestionAnalysis +
			", examquestionSequence=" + examquestionSequence +
			"} " + super.toString();
	}
}
