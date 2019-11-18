package com.icloud.house.model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * @author Mr.Z
 * @email 512162086@qq.com
 * @date 2019-11-14 09:40:23
 */
@TableName("t_house_share_item")
public class HouseShareItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
   	   /*  */
       @TableId(value="id", type= IdType.AUTO)
       private Long id;
   	   	   /* 头图 */
       @TableField("image_url")
       private String imageUrl;
   	   	   /* 名称描述（独立办公室/三人间） */
       @TableField("itemname")
       private String itemname;
   	   	   /* 2400
            2000
            价格   （元/工位/月） */
       @TableField("price")
       private BigDecimal price;
   	   	   /* 父id(房源表种的id) */
       @TableField("parent_id")
       private Long parentId;
   	
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
	 * 设置：头图
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：头图
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 设置：名称描述（独立办公室/三人间）
	 */
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	/**
	 * 获取：名称描述（独立办公室/三人间）
	 */
	public String getItemname() {
		return itemname;
	}
	/**
	 * 设置：2400
            2000
            价格   （元/工位/月）
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：2400
            2000
            价格   （元/工位/月）
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：父id(房源表种的id)
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父id(房源表种的id)
	 */
	public Long getParentId() {
		return parentId;
	}

    @Override
    public String toString() {
        return "HouseShareItem{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", itemname='" + itemname + '\'' +
                ", price=" + price +
                ", parentId=" + parentId +
                '}';
    }
}
