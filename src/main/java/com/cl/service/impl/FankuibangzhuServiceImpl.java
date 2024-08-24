package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FankuibangzhuDao;
import com.cl.entity.FankuibangzhuEntity;
import com.cl.service.FankuibangzhuService;
import com.cl.entity.view.FankuibangzhuView;

@Service("fankuibangzhuService")
public class FankuibangzhuServiceImpl extends ServiceImpl<FankuibangzhuDao, FankuibangzhuEntity> implements FankuibangzhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FankuibangzhuEntity> page = this.selectPage(
                new Query<FankuibangzhuEntity>(params).getPage(),
                new EntityWrapper<FankuibangzhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FankuibangzhuEntity> wrapper) {
		  Page<FankuibangzhuView> page =new Query<FankuibangzhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FankuibangzhuView> selectListView(Wrapper<FankuibangzhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FankuibangzhuView selectView(Wrapper<FankuibangzhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
