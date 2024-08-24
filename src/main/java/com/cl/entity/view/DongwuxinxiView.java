package com.cl.entity.view;

import com.cl.entity.DongwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 动物信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
@TableName("dongwuxinxi")
public class DongwuxinxiView  extends DongwuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DongwuxinxiView(){
	}
 
 	public DongwuxinxiView(DongwuxinxiEntity dongwuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, dongwuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
