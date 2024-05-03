package com.dao;

import com.entity.ZhixunshiChatEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhixunshiChatView;

/**
 * 心理咨询 Dao 接口
 *
 * @author 
 */
public interface ZhixunshiChatDao extends BaseMapper<ZhixunshiChatEntity> {

   List<ZhixunshiChatView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
