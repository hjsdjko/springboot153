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

import com.cl.entity.FankuibangzhuEntity;
import com.cl.entity.view.FankuibangzhuView;

import com.cl.service.FankuibangzhuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 反馈帮助
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
@RestController
@RequestMapping("/fankuibangzhu")
public class FankuibangzhuController {
    @Autowired
    private FankuibangzhuService fankuibangzhuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FankuibangzhuEntity fankuibangzhu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			fankuibangzhu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FankuibangzhuEntity> ew = new EntityWrapper<FankuibangzhuEntity>();

		PageUtils page = fankuibangzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fankuibangzhu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FankuibangzhuEntity fankuibangzhu, 
		HttpServletRequest request){
        EntityWrapper<FankuibangzhuEntity> ew = new EntityWrapper<FankuibangzhuEntity>();

		PageUtils page = fankuibangzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fankuibangzhu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FankuibangzhuEntity fankuibangzhu){
       	EntityWrapper<FankuibangzhuEntity> ew = new EntityWrapper<FankuibangzhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fankuibangzhu, "fankuibangzhu")); 
        return R.ok().put("data", fankuibangzhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FankuibangzhuEntity fankuibangzhu){
        EntityWrapper< FankuibangzhuEntity> ew = new EntityWrapper< FankuibangzhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fankuibangzhu, "fankuibangzhu")); 
		FankuibangzhuView fankuibangzhuView =  fankuibangzhuService.selectView(ew);
		return R.ok("查询反馈帮助成功").put("data", fankuibangzhuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FankuibangzhuEntity fankuibangzhu = fankuibangzhuService.selectById(id);
		fankuibangzhu = fankuibangzhuService.selectView(new EntityWrapper<FankuibangzhuEntity>().eq("id", id));
        return R.ok().put("data", fankuibangzhu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FankuibangzhuEntity fankuibangzhu = fankuibangzhuService.selectById(id);
		fankuibangzhu = fankuibangzhuService.selectView(new EntityWrapper<FankuibangzhuEntity>().eq("id", id));
        return R.ok().put("data", fankuibangzhu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FankuibangzhuEntity fankuibangzhu, HttpServletRequest request){
    	fankuibangzhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fankuibangzhu);
        fankuibangzhuService.insert(fankuibangzhu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FankuibangzhuEntity fankuibangzhu, HttpServletRequest request){
    	fankuibangzhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fankuibangzhu);
        fankuibangzhuService.insert(fankuibangzhu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FankuibangzhuEntity fankuibangzhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fankuibangzhu);
        fankuibangzhuService.updateById(fankuibangzhu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fankuibangzhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
