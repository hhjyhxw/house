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
@TableName("t_house_browse")
public class HouseBrowseRecords implements Serializable {
	private static final long serialVersionUID = 1L;
	
   	   /*  */
       @TableId(value="id", type= IdType.AUTO)
       private Long id;
   	   	   /* house_id */
       @TableField("house_id")
       private Long houseId;
   	   	   /* 浏览时间 */
       @TableField("create_time")
       private Date createTime;
   	   	   /* 用户id */
       @TableField("user_id")
       private Long userId;
   	
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
	 * 设置：house_id
	 */
	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}
	/**
	 * 获取：house_id
	 */
	public Long getHouseId() {
		return houseId;
	}
	/**
	 * 设置：浏览时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：浏览时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
}
