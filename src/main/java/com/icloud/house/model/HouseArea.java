package com.icloud.house.model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-01 21:46:50
 */
@TableName("t_house_area")
public class HouseArea implements Serializable {
	private static final long serialVersionUID = 1L;
	
   	   /*  */
       @TableId(value="id", type= IdType.AUTO)
       private Long id;
   	   	   /* 区域编号 */
       @TableField("aren_code")
       private String arenCode;
   	   	   /* 状态（0停用、1使用） */
       @TableField("parent_code")
       private Integer parentCode;
   	   	   /* 区域名称 */
       @TableField("arean_name")
       private String areanName;
   	   	   /* 等级(0级根、1及省、2、市、3区县、4乡镇) */
       @TableField("aren_level")
       private Integer arenLevel;
   	
	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：区域编号
	 */
	public void setArenCode(String arenCode) {
		this.arenCode = arenCode;
	}
	/**
	 * 获取：区域编号
	 */
	public String getArenCode() {
		return arenCode;
	}
	/**
	 * 设置：状态（0停用、1使用）
	 */
	public void setParentCode(Integer parentCode) {
		this.parentCode = parentCode;
	}
	/**
	 * 获取：状态（0停用、1使用）
	 */
	public Integer getParentCode() {
		return parentCode;
	}
	/**
	 * 设置：区域名称
	 */
	public void setAreanName(String areanName) {
		this.areanName = areanName;
	}
	/**
	 * 获取：区域名称
	 */
	public String getAreanName() {
		return areanName;
	}
	/**
	 * 设置：等级(0级根、1及省、2、市、3区县、4乡镇)
	 */
	public void setArenLevel(Integer arenLevel) {
		this.arenLevel = arenLevel;
	}
	/**
	 * 获取：等级(0级根、1及省、2、市、3区县、4乡镇)
	 */
	public Integer getArenLevel() {
		return arenLevel;
	}
}
