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


import com.cl.dao.XuexiziliaoDao;
import com.cl.entity.XuexiziliaoEntity;
import com.cl.service.XuexiziliaoService;
import com.cl.entity.view.XuexiziliaoView;

@Service("xuexiziliaoService")
public class XuexiziliaoServiceImpl extends ServiceImpl<XuexiziliaoDao, XuexiziliaoEntity> implements XuexiziliaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuexiziliaoEntity> page = this.selectPage(
                new Query<XuexiziliaoEntity>(params).getPage(),
                new EntityWrapper<XuexiziliaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuexiziliaoEntity> wrapper) {
		  Page<XuexiziliaoView> page =new Query<XuexiziliaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XuexiziliaoView> selectListView(Wrapper<XuexiziliaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuexiziliaoView selectView(Wrapper<XuexiziliaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
