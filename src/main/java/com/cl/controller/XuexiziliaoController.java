package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XuexiziliaoEntity;
import com.cl.entity.view.XuexiziliaoView;

import com.cl.service.XuexiziliaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 学习资料
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
@RestController
@RequestMapping("/xuexiziliao")
public class XuexiziliaoController {
    @Autowired
    private XuexiziliaoService xuexiziliaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuexiziliaoEntity xuexiziliao,
		HttpServletRequest request){
        EntityWrapper<XuexiziliaoEntity> ew = new EntityWrapper<XuexiziliaoEntity>();

		PageUtils page = xuexiziliaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexiziliao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuexiziliaoEntity xuexiziliao, 
		HttpServletRequest request){
        EntityWrapper<XuexiziliaoEntity> ew = new EntityWrapper<XuexiziliaoEntity>();

		PageUtils page = xuexiziliaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexiziliao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuexiziliaoEntity xuexiziliao){
       	EntityWrapper<XuexiziliaoEntity> ew = new EntityWrapper<XuexiziliaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuexiziliao, "xuexiziliao")); 
        return R.ok().put("data", xuexiziliaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuexiziliaoEntity xuexiziliao){
        EntityWrapper< XuexiziliaoEntity> ew = new EntityWrapper< XuexiziliaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuexiziliao, "xuexiziliao")); 
		XuexiziliaoView xuexiziliaoView =  xuexiziliaoService.selectView(ew);
		return R.ok("查询学习资料成功").put("data", xuexiziliaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuexiziliaoEntity xuexiziliao = xuexiziliaoService.selectById(id);
		xuexiziliao = xuexiziliaoService.selectView(new EntityWrapper<XuexiziliaoEntity>().eq("id", id));
        return R.ok().put("data", xuexiziliao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuexiziliaoEntity xuexiziliao = xuexiziliaoService.selectById(id);
		xuexiziliao = xuexiziliaoService.selectView(new EntityWrapper<XuexiziliaoEntity>().eq("id", id));
        return R.ok().put("data", xuexiziliao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuexiziliaoEntity xuexiziliao, HttpServletRequest request){
    	xuexiziliao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexiziliao);
        xuexiziliaoService.insert(xuexiziliao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuexiziliaoEntity xuexiziliao, HttpServletRequest request){
    	xuexiziliao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexiziliao);
        xuexiziliaoService.insert(xuexiziliao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XuexiziliaoEntity xuexiziliao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuexiziliao);
        xuexiziliaoService.updateById(xuexiziliao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuexiziliaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
