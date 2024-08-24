package com.cl.dao;

import com.cl.entity.DongwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DongwuxinxiView;


/**
 * 动物信息
 * 
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
public interface DongwuxinxiDao extends BaseMapper<DongwuxinxiEntity> {
	
	List<DongwuxinxiView> selectListView(@Param("ew") Wrapper<DongwuxinxiEntity> wrapper);

	List<DongwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DongwuxinxiEntity> wrapper);
	
	DongwuxinxiView selectView(@Param("ew") Wrapper<DongwuxinxiEntity> wrapper);
	

}
