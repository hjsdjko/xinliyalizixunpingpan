package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ExampapertopicEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 心理测评选题
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("exampapertopic")
public class ExampapertopicView extends ExampapertopicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 心理测评表
		/**
		* 心理测评名称
		*/

		@ColumnInfo(comment="心理测评名称",type="varchar(200)")
		private String exampaperName;
		/**
		* 心理测评时长(分钟)
		*/

		@ColumnInfo(comment="心理测评时长(分钟)",type="int(11)")
		private Integer exampaperDate;
		/**
		* 心理测评总分数
		*/

		@ColumnInfo(comment="心理测评总分数",type="int(20)")
		private Integer exampaperMyscore;
		/**
		* 心理测评状态
		*/
		@ColumnInfo(comment="心理测评状态",type="int(11)")
		private Integer exampaperTypes;
			/**
			* 心理测评状态的值
			*/
			@ColumnInfo(comment="心理测评状态的字典表值",type="varchar(200)")
			private String exampaperValue;
		/**
		* 组卷方式
		*/
		@ColumnInfo(comment="组卷方式",type="int(11)")
		private Integer zujuanTypes;
			/**
			* 组卷方式的值
			*/
			@ColumnInfo(comment="组卷方式的字典表值",type="varchar(200)")
			private String zujuanValue;
		/**
		* 逻辑删除（1代表未删除 2代表已删除）
		*/

		@ColumnInfo(comment="逻辑删除（1代表未删除 2代表已删除）",type="int(255)")
		private Integer exampaperDelete;
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



	public ExampapertopicView() {

	}

	public ExampapertopicView(ExampapertopicEntity exampapertopicEntity) {
		try {
			BeanUtils.copyProperties(this, exampapertopicEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 心理测评表

		/**
		* 获取： 心理测评名称
		*/
		public String getExampaperName() {
			return exampaperName;
		}
		/**
		* 设置： 心理测评名称
		*/
		public void setExampaperName(String exampaperName) {
			this.exampaperName = exampaperName;
		}

		/**
		* 获取： 心理测评时长(分钟)
		*/
		public Integer getExampaperDate() {
			return exampaperDate;
		}
		/**
		* 设置： 心理测评时长(分钟)
		*/
		public void setExampaperDate(Integer exampaperDate) {
			this.exampaperDate = exampaperDate;
		}

		/**
		* 获取： 心理测评总分数
		*/
		public Integer getExampaperMyscore() {
			return exampaperMyscore;
		}
		/**
		* 设置： 心理测评总分数
		*/
		public void setExampaperMyscore(Integer exampaperMyscore) {
			this.exampaperMyscore = exampaperMyscore;
		}
		/**
		* 获取： 心理测评状态
		*/
		public Integer getExampaperTypes() {
			return exampaperTypes;
		}
		/**
		* 设置： 心理测评状态
		*/
		public void setExampaperTypes(Integer exampaperTypes) {
			this.exampaperTypes = exampaperTypes;
		}


			/**
			* 获取： 心理测评状态的值
			*/
			public String getExampaperValue() {
				return exampaperValue;
			}
			/**
			* 设置： 心理测评状态的值
			*/
			public void setExampaperValue(String exampaperValue) {
				this.exampaperValue = exampaperValue;
			}
		/**
		* 获取： 组卷方式
		*/
		public Integer getZujuanTypes() {
			return zujuanTypes;
		}
		/**
		* 设置： 组卷方式
		*/
		public void setZujuanTypes(Integer zujuanTypes) {
			this.zujuanTypes = zujuanTypes;
		}


			/**
			* 获取： 组卷方式的值
			*/
			public String getZujuanValue() {
				return zujuanValue;
			}
			/**
			* 设置： 组卷方式的值
			*/
			public void setZujuanValue(String zujuanValue) {
				this.zujuanValue = zujuanValue;
			}

		/**
		* 获取： 逻辑删除（1代表未删除 2代表已删除）
		*/
		public Integer getExampaperDelete() {
			return exampaperDelete;
		}
		/**
		* 设置： 逻辑删除（1代表未删除 2代表已删除）
		*/
		public void setExampaperDelete(Integer exampaperDelete) {
			this.exampaperDelete = exampaperDelete;
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


	@Override
	public String toString() {
		return "ExampapertopicView{" +
			", examquestionName=" + examquestionName +
			", examquestionOptions=" + examquestionOptions +
			", examquestionAnswer=" + examquestionAnswer +
			", examquestionAnalysis=" + examquestionAnalysis +
			", examquestionSequence=" + examquestionSequence +
			", exampaperName=" + exampaperName +
			", exampaperDate=" + exampaperDate +
			", exampaperMyscore=" + exampaperMyscore +
			", exampaperDelete=" + exampaperDelete +
			"} " + super.toString();
	}
}
