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


import com.cl.dao.DongwuxinxiDao;
import com.cl.entity.DongwuxinxiEntity;
import com.cl.service.DongwuxinxiService;
import com.cl.entity.view.DongwuxinxiView;

@Service("dongwuxinxiService")
public class DongwuxinxiServiceImpl extends ServiceImpl<DongwuxinxiDao, DongwuxinxiEntity> implements DongwuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DongwuxinxiEntity> page = this.selectPage(
                new Query<DongwuxinxiEntity>(params).getPage(),
                new EntityWrapper<DongwuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DongwuxinxiEntity> wrapper) {
		  Page<DongwuxinxiView> page =new Query<DongwuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DongwuxinxiView> selectListView(Wrapper<DongwuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DongwuxinxiView selectView(Wrapper<DongwuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
