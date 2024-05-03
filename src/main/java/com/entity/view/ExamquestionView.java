package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ExamquestionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 题目表
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("examquestion")
public class ExamquestionView extends ExamquestionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 题目类型的值
	*/
	@ColumnInfo(comment="题目类型的字典表值",type="varchar(200)")
	private String examquestionValue;




	public ExamquestionView() {

	}

	public ExamquestionView(ExamquestionEntity examquestionEntity) {
		try {
			BeanUtils.copyProperties(this, examquestionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "ExamquestionView{" +
			", examquestionValue=" + examquestionValue +
			"} " + super.toString();
	}
}
