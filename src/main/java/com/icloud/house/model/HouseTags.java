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
 * @date 2019-11-01 21:46:51
 */
@TableName("t_house_tags")
public class HouseTags implements Serializable {
	private static final long serialVersionUID = 1L;
	
   	   /*  */
       @TableId(value="id", type= IdType.AUTO)
       private Long id;
   	   	   /* 标签名称（如、独栋、热门、最新、爆款等） */
       @TableField("标签名称")
       private String 标签名称;
   	   	   /* 状态（0停用、1使用） */
       @TableField("状态")
       private Integer 状态;
   	
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
	 * 设置：标签名称（如、独栋、热门、最新、爆款等）
	 */
	public void set标签名称(String 标签名称) {
		this.标签名称 = 标签名称;
	}
	/**
	 * 获取：标签名称（如、独栋、热门、最新、爆款等）
	 */
	public String get标签名称() {
		return 标签名称;
	}
	/**
	 * 设置：状态（0停用、1使用）
	 */
	public void set状态(Integer 状态) {
		this.状态 = 状态;
	}
	/**
	 * 获取：状态（0停用、1使用）
	 */
	public Integer get状态() {
		return 状态;
	}
}
