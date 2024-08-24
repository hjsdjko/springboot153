package com.cl.dao;

import com.cl.entity.FankuibangzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FankuibangzhuView;


/**
 * 反馈帮助
 * 
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
public interface FankuibangzhuDao extends BaseMapper<FankuibangzhuEntity> {
	
	List<FankuibangzhuView> selectListView(@Param("ew") Wrapper<FankuibangzhuEntity> wrapper);

	List<FankuibangzhuView> selectListView(Pagination page,@Param("ew") Wrapper<FankuibangzhuEntity> wrapper);
	
	FankuibangzhuView selectView(@Param("ew") Wrapper<FankuibangzhuEntity> wrapper);
	

}
