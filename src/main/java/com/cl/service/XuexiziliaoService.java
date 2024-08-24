package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XuexiziliaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XuexiziliaoView;


/**
 * 学习资料
 *
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
public interface XuexiziliaoService extends IService<XuexiziliaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuexiziliaoView> selectListView(Wrapper<XuexiziliaoEntity> wrapper);
   	
   	XuexiziliaoView selectView(@Param("ew") Wrapper<XuexiziliaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuexiziliaoEntity> wrapper);
   	

}

