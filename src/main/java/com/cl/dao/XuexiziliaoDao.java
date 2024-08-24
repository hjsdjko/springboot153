package com.cl.dao;

import com.cl.entity.XuexiziliaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XuexiziliaoView;


/**
 * 学习资料
 * 
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
public interface XuexiziliaoDao extends BaseMapper<XuexiziliaoEntity> {
	
	List<XuexiziliaoView> selectListView(@Param("ew") Wrapper<XuexiziliaoEntity> wrapper);

	List<XuexiziliaoView> selectListView(Pagination page,@Param("ew") Wrapper<XuexiziliaoEntity> wrapper);
	
	XuexiziliaoView selectView(@Param("ew") Wrapper<XuexiziliaoEntity> wrapper);
	

}
