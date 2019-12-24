package com.icloud.commons.model;
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
 * @date 2019-12-24 09:06:27
 */
@TableName("t_commons_ad")
public class CommonsAd implements Serializable {
	private static final long serialVersionUID = 1L;
	
   	   /*  */
       @TableId(value="id", type= IdType.AUTO)
       private Long id;
   	   	   /* 名称 */
       @TableField("ad_name")
       private String adName;
   	   	   /* 图片url */
       @TableField("ad_imgurl")
       private String adImgurl;
   	   	   /* 跳转url */
       @TableField("add_jumpurl")
       private String addJumpurl;
   	   	   /* 0停用、1启用 */
       @TableField("status")
       private String status;
   	   	   /* 创建时间 */
       @TableField("create_time")
       private Date createTime;
   	   	   /* 创建人 */
       @TableField("create_operator")
       private String createOperator;
   	   	   /* 修改时间 */
       @TableField("modify_time")
       private Date modifyTime;
   	   	   /* 修改人 */
       @TableField("modify_operator")
       private String modifyOperator;
   	   	   /* 所属位置id */
       @TableField("posittion_id")
       private Long posittionId;
   	   	   /* 排序 */
       @TableField("sort_num")
       private Integer sortNum;
   	
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
	 * 设置：名称
	 */
	public void setAdName(String adName) {
		this.adName = adName;
	}
	/**
	 * 获取：名称
	 */
	public String getAdName() {
		return adName;
	}
	/**
	 * 设置：图片url
	 */
	public void setAdImgurl(String adImgurl) {
		this.adImgurl = adImgurl;
	}
	/**
	 * 获取：图片url
	 */
	public String getAdImgurl() {
		return adImgurl;
	}
	/**
	 * 设置：跳转url
	 */
	public void setAddJumpurl(String addJumpurl) {
		this.addJumpurl = addJumpurl;
	}
	/**
	 * 获取：跳转url
	 */
	public String getAddJumpurl() {
		return addJumpurl;
	}
	/**
	 * 设置：0停用、1启用
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：0停用、1启用
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateOperator() {
		return createOperator;
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
	/**
	 * 设置：修改人
	 */
	public void setModifyOperator(String modifyOperator) {
		this.modifyOperator = modifyOperator;
	}
	/**
	 * 获取：修改人
	 */
	public String getModifyOperator() {
		return modifyOperator;
	}
	/**
	 * 设置：所属位置id
	 */
	public void setPosittionId(Long posittionId) {
		this.posittionId = posittionId;
	}
	/**
	 * 获取：所属位置id
	 */
	public Long getPosittionId() {
		return posittionId;
	}
	/**
	 * 设置：排序
	 */
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSortNum() {
		return sortNum;
	}
}
