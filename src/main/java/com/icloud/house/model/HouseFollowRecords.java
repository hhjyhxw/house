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
 * @date 2019-11-25 11:50:17
 */
@TableName("t_house_follow_records")
public class HouseFollowRecords implements Serializable {
	private static final long serialVersionUID = 1L;
	
   	   /*  */
       @TableId(value="id", type= IdType.AUTO)
       private Long id;
   	   	   /* house_id */
       @TableField("house_id")
       private Long houseId;
   	   	   /* 关注时间 */
       @TableField("create_time")
       private Date createTime;
   	   	   /* 用户id */
       @TableField("user_id")
       private Long userId;
   	   	   /* status 0 取消关注 1关注 */
       @TableField("status")
       private String status;
   	   	   /* 修改时间 */
       @TableField("modify_time")
       private Date modifyTime;
   	
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
	 * 设置：关注时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：关注时间
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
	/**
	 * 设置：status 0 取消关注 1关注
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：status 0 取消关注 1关注
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
}
