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

import com.cl.entity.DongwuxinxiEntity;
import com.cl.entity.view.DongwuxinxiView;

import com.cl.service.DongwuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import java.io.File;
import org.json.JSONObject;
import com.cl.utils.BaiduUtil;
import org.springframework.util.ResourceUtils;
import java.io.FileNotFoundException;

/**
 * 动物信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
@RestController
@RequestMapping("/dongwuxinxi")
public class DongwuxinxiController {
    @Autowired
    private DongwuxinxiService dongwuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DongwuxinxiEntity dongwuxinxi,
		HttpServletRequest request){
        EntityWrapper<DongwuxinxiEntity> ew = new EntityWrapper<DongwuxinxiEntity>();

		PageUtils page = dongwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongwuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DongwuxinxiEntity dongwuxinxi, 
		HttpServletRequest request){
        EntityWrapper<DongwuxinxiEntity> ew = new EntityWrapper<DongwuxinxiEntity>();

		PageUtils page = dongwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongwuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DongwuxinxiEntity dongwuxinxi){
       	EntityWrapper<DongwuxinxiEntity> ew = new EntityWrapper<DongwuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dongwuxinxi, "dongwuxinxi")); 
        return R.ok().put("data", dongwuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DongwuxinxiEntity dongwuxinxi){
        EntityWrapper< DongwuxinxiEntity> ew = new EntityWrapper< DongwuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dongwuxinxi, "dongwuxinxi")); 
		DongwuxinxiView dongwuxinxiView =  dongwuxinxiService.selectView(ew);
		return R.ok("查询动物信息成功").put("data", dongwuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DongwuxinxiEntity dongwuxinxi = dongwuxinxiService.selectById(id);
		dongwuxinxi = dongwuxinxiService.selectView(new EntityWrapper<DongwuxinxiEntity>().eq("id", id));
        return R.ok().put("data", dongwuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DongwuxinxiEntity dongwuxinxi = dongwuxinxiService.selectById(id);
		dongwuxinxi = dongwuxinxiService.selectView(new EntityWrapper<DongwuxinxiEntity>().eq("id", id));
        return R.ok().put("data", dongwuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DongwuxinxiEntity dongwuxinxi, HttpServletRequest request){
    	dongwuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongwuxinxi);
        dongwuxinxiService.insert(dongwuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DongwuxinxiEntity dongwuxinxi, HttpServletRequest request){
    	dongwuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongwuxinxi);
        dongwuxinxiService.insert(dongwuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DongwuxinxiEntity dongwuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dongwuxinxi);
        dongwuxinxiService.updateById(dongwuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dongwuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







    /**
     * 动物识别
     */
    @RequestMapping("/baidu/animal")
    @IgnoreAuth
    public R baiduAnimal(@RequestParam("fileName") String fileName,HttpServletRequest request) {
        JSONObject jb = null;
        try {
            File path = new File(ResourceUtils.getURL("classpath:static").getPath());
            if(!path.exists()) {
                path = new File("");
            }
            File upload = new File(path.getAbsolutePath(),"/file/");
            if(!upload.exists()) {
                upload.mkdirs();
            }
            File file = new File(upload.getAbsolutePath()+"/"+fileName);
            if(file.exists()){
                jb = BaiduUtil.animalDetect(file.getAbsolutePath());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return R.ok().put("data", com.alibaba.fastjson.JSONObject.parseObject(jb.getJSONArray("result").get(0).toString()));
    }

}
