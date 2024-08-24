package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DongwuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DongwuxinxiView;


/**
 * 动物信息
 *
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
public interface DongwuxinxiService extends IService<DongwuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DongwuxinxiView> selectListView(Wrapper<DongwuxinxiEntity> wrapper);
   	
   	DongwuxinxiView selectView(@Param("ew") Wrapper<DongwuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DongwuxinxiEntity> wrapper);
   	

}

