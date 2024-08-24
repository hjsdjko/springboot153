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
 * 动物信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
@TableName("dongwuxinxi")
public class DongwuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DongwuxinxiEntity() {
		
	}
	
	public DongwuxinxiEntity(T t) {
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
					
	private String dongwumingcheng;
	
	/**
	 * 图片
	 */
					
	private String dongwutupian;
	
	
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
	public void setDongwumingcheng(String dongwumingcheng) {
		this.dongwumingcheng = dongwumingcheng;
	}
	/**
	 * 获取：名称
	 */
	public String getDongwumingcheng() {
		return dongwumingcheng;
	}
	/**
	 * 设置：图片
	 */
	public void setDongwutupian(String dongwutupian) {
		this.dongwutupian = dongwutupian;
	}
	/**
	 * 获取：图片
	 */
	public String getDongwutupian() {
		return dongwutupian;
	}

}
