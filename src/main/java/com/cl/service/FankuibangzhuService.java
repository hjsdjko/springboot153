package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.FankuibangzhuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FankuibangzhuView;


/**
 * 反馈帮助
 *
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
public interface FankuibangzhuService extends IService<FankuibangzhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FankuibangzhuView> selectListView(Wrapper<FankuibangzhuEntity> wrapper);
   	
   	FankuibangzhuView selectView(@Param("ew") Wrapper<FankuibangzhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FankuibangzhuEntity> wrapper);
   	

}

