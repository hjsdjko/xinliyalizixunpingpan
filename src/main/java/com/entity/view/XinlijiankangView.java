package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XinlijiankangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 心理健康
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xinlijiankang")
public class XinlijiankangView extends XinlijiankangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 心理健康类型的值
	*/
	@ColumnInfo(comment="心理健康类型的字典表值",type="varchar(200)")
	private String xinlijiankangValue;




	public XinlijiankangView() {

	}

	public XinlijiankangView(XinlijiankangEntity xinlijiankangEntity) {
		try {
			BeanUtils.copyProperties(this, xinlijiankangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "XinlijiankangView{" +
			", xinlijiankangValue=" + xinlijiankangValue +
			"} " + super.toString();
	}
}
