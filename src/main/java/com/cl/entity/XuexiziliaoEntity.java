package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 学习资料
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
@TableName("xuexiziliao")
public class XuexiziliaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XuexiziliaoEntity() {
		
	}
	
	public XuexiziliaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 名称
	 */
					
	private String mingcheng;
	
	/**
	 * 种类
	 */
					
	private String zhonglei;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 形态特征
	 */
					
	private String xingtaitezheng;
	
	/**
	 * 生活习性
	 */
					
	private String shenghuoxixing;
	
	/**
	 * 分布范围
	 */
					
	private String fenbufanwei;
	
	/**
	 * 种类详情
	 */
					
	private String zhongleixiangqing;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：名称
	 */
	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	/**
	 * 获取：名称
	 */
	public String getMingcheng() {
		return mingcheng;
	}
	/**
	 * 设置：种类
	 */
	public void setZhonglei(String zhonglei) {
		this.zhonglei = zhonglei;
	}
	/**
	 * 获取：种类
	 */
	public String getZhonglei() {
		return zhonglei;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：形态特征
	 */
	public void setXingtaitezheng(String xingtaitezheng) {
		this.xingtaitezheng = xingtaitezheng;
	}
	/**
	 * 获取：形态特征
	 */
	public String getXingtaitezheng() {
		return xingtaitezheng;
	}
	/**
	 * 设置：生活习性
	 */
	public void setShenghuoxixing(String shenghuoxixing) {
		this.shenghuoxixing = shenghuoxixing;
	}
	/**
	 * 获取：生活习性
	 */
	public String getShenghuoxixing() {
		return shenghuoxixing;
	}
	/**
	 * 设置：分布范围
	 */
	public void setFenbufanwei(String fenbufanwei) {
		this.fenbufanwei = fenbufanwei;
	}
	/**
	 * 获取：分布范围
	 */
	public String getFenbufanwei() {
		return fenbufanwei;
	}
	/**
	 * 设置：种类详情
	 */
	public void setZhongleixiangqing(String zhongleixiangqing) {
		this.zhongleixiangqing = zhongleixiangqing;
	}
	/**
	 * 获取：种类详情
	 */
	public String getZhongleixiangqing() {
		return zhongleixiangqing;
	}

}
