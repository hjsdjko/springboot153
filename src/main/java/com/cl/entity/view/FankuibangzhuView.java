package com.cl.entity.view;

import com.cl.entity.FankuibangzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 反馈帮助
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-05 18:23:32
 */
@TableName("fankuibangzhu")
public class FankuibangzhuView  extends FankuibangzhuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FankuibangzhuView(){
	}
 
 	public FankuibangzhuView(FankuibangzhuEntity fankuibangzhuEntity){
 	try {
			BeanUtils.copyProperties(this, fankuibangzhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
