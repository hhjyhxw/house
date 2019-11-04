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
@TableName("t_house_apply")
public class HouseApply implements Serializable {
	private static final long serialVersionUID = 1L;
	
   	   /*  */
       @TableId(value="id", type= IdType.AUTO)
       private Long id;
   	   	   /*  */
       @TableField("user_id")
       private Long userId;
   	   	   /*  */
       @TableField("name")
       private String name;
   	   	   /*  */
       @TableField("phone")
       private String phone;
   	   	   /*  */
       @TableField("create_time")
       private Date createTime;
   	   	   /* 申请状态(0待审批、1审批种、2申请成功) */
       @TableField("status")
       private Integer status;
   	
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
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：申请状态(0待审批、1审批种、2申请成功)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：申请状态(0待审批、1审批种、2申请成功)
	 */
	public Integer getStatus() {
		return status;
	}
}
