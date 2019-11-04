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
@TableName("t_house_attrubit")
public class HouseAttrubit implements Serializable {
	private static final long serialVersionUID = 1L;
	
   	   /* id */
       @TableId(value="id", type= IdType.AUTO)
       private Long id;
   	   	   /* 所属房屋信息 */
       @TableField("house_id")
       private Long houseId;
   	   	   /* values */
       @TableField("name")
       private String name;
   	   	   /* values */
       @TableField("value")
       private String value;
   	
	/**
	 * 设置：id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：所属房屋信息
	 */
	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}
	/**
	 * 获取：所属房屋信息
	 */
	public Long getHouseId() {
		return houseId;
	}
	/**
	 * 设置：values
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：values
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：values
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：values
	 */
	public String getValue() {
		return value;
	}
}
