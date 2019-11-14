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
 * @date 2019-11-04 10:13:30
 */
@TableName("t_house_housing")
public class HouseHousing implements Serializable {
	private static final long serialVersionUID = 1L;
	
   	   /*  */
       @TableId(value="id", type= IdType.AUTO)
       private Long id;
   	   	   /* 标题 */
       @TableField("title")
       private String title;
   	   	   /* 最低总售价 */
       @TableField("min_total_price")
       private BigDecimal minTotalPrice;
   	   	   /* 最高总售价 */
       @TableField("max_total_price")
       private BigDecimal maxTotalPrice;
   	   	   /* 最低单价 */
       @TableField("min_unit_price")
       private BigDecimal minUnitPrice;
   	   	   /* 最高单价 */
       @TableField("max_unit_price")
       private BigDecimal maxUnitPrice;
   	   	   /* 均价 */
       @TableField("average_priice")
       private BigDecimal averagePriice;
   	   	   /* 最低总面积 */
       @TableField("min_house_area")
       private Integer minHouseArea;
   	   	   /* 最高总面积 */
       @TableField("max_house_area")
       private Integer maxHouseArea;
   	   	   /* 所属楼层 */
       @TableField("storey")
       private Integer storey;
   	   	   /* 分类（1、写字楼、2 新房 3、共享办公、4租房） */
       @TableField("house_type")
       private Integer houseType;
   	   	   /* 状态 上架 下架（0下架、1上架） */
       @TableField("status")
       private Integer status;
   	   	   /* 文字详情 */
       @TableField("describes")
       private String describes;
   	   	   /* 图片详情 */
       @TableField("introduction_detail")
       private String introductionDetail;

        /* 基础服务 */
        @TableField("base_servicer")
        private String baseServicer;

        /* 企业服务 */
        @TableField("enterprise_servicer")
        private String enterpriseServicer;


   	   	   /* 所在小区 */
       @TableField("village")
       private String village;
   	   	   /* 地址 */
       @TableField("addesses")
       private String addesses;
   	   	   /* 房源，房屋来源(0房东、1中介) */
       @TableField("house_sources")
       private Integer houseSources;
   	   	   /* 租房方式(0整租，1合租)  */
       @TableField("rent_way")
       private Integer rentWay;
   	   	   /* 建筑面积（新楼盘需要） */
       @TableField("build_area")
       private String buildArea;
   	   	   /* 开盘时间（新楼盘需要） */
       @TableField("open_date")
       private Date openDate;
   	   	   /* 入住时间（新楼盘需要） */
       @TableField("into_date")
       private Date intoDate;
   	   	   /* 经度 */
       @TableField("lng")
       private BigDecimal lng;
   	   	   /* 维度 */
       @TableField("lat")
       private BigDecimal lat;
   	   	   /* 省 */
       @TableField("province")
       private String province;
   	   	   /* 市 */
       @TableField("city")
       private String city;
   	   	   /* 县、区 */
       @TableField("county")
       private String county;
   	   	   /* 乡、镇 */
       @TableField("towns")
       private String towns;
   	   	   /* 发布人ID */
       @TableField("pub_user")
       private Long pubUser;//微信用户
   	   	   /* 标签 */
       @TableField("tags")
       private String tags;
   	   	   /* 特色 */
       @TableField("features")
       private String features;
   	   	   /* 装修 */
       @TableField("fitup")
       private String fitup;
   	   	   /* 房型 */
       @TableField("house_classs")
       private String houseClasss;
   	   	   /* 特价房（0否，1是） */
       @TableField("specifyes")
       private String specifyes;
   	   	   /* 最新（0否，1是） */
       @TableField("latest")
       private String latest;
   	   	   /* 物业类型 */
       @TableField("property_type")
       private String propertyType;

    /* 是否可以租(0不可以组,1可以组) */
    @TableField("rentable")
    private String rentable;

    /* 创建时间 */
    @TableField("create_time")
    private Date createTime;
    /* 更新人 */
    @TableField("modify_man")
    private Long modifyMan;
    /* 更新时间 */
    @TableField("modify_time")
    private Date modifyTime;
    /* 创建人 */
    @TableField("create_man")
    private Long createMan;

    /* 封面图 */
    @TableField("image_url")
    private String imageUrl;


   	
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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：最低总售价
	 */
	public void setMinTotalPrice(BigDecimal minTotalPrice) {
		this.minTotalPrice = minTotalPrice;
	}
	/**
	 * 获取：最低总售价
	 */
	public BigDecimal getMinTotalPrice() {
		return minTotalPrice;
	}
	/**
	 * 设置：最高总售价
	 */
	public void setMaxTotalPrice(BigDecimal maxTotalPrice) {
		this.maxTotalPrice = maxTotalPrice;
	}
	/**
	 * 获取：最高总售价
	 */
	public BigDecimal getMaxTotalPrice() {
		return maxTotalPrice;
	}
	/**
	 * 设置：最低单价
	 */
	public void setMinUnitPrice(BigDecimal minUnitPrice) {
		this.minUnitPrice = minUnitPrice;
	}
	/**
	 * 获取：最低单价
	 */
	public BigDecimal getMinUnitPrice() {
		return minUnitPrice;
	}
	/**
	 * 设置：最高单价
	 */
	public void setMaxUnitPrice(BigDecimal maxUnitPrice) {
		this.maxUnitPrice = maxUnitPrice;
	}
	/**
	 * 获取：最高单价
	 */
	public BigDecimal getMaxUnitPrice() {
		return maxUnitPrice;
	}
	/**
	 * 设置：均价
	 */
	public void setAveragePriice(BigDecimal averagePriice) {
		this.averagePriice = averagePriice;
	}
	/**
	 * 获取：均价
	 */
	public BigDecimal getAveragePriice() {
		return averagePriice;
	}
	/**
	 * 设置：最低总面积
	 */
	public void setMinHouseArea(Integer minHouseArea) {
		this.minHouseArea = minHouseArea;
	}
	/**
	 * 获取：最低总面积
	 */
	public Integer getMinHouseArea() {
		return minHouseArea;
	}
	/**
	 * 设置：最高总面积
	 */
	public void setMaxHouseArea(Integer maxHouseArea) {
		this.maxHouseArea = maxHouseArea;
	}
	/**
	 * 获取：最高总面积
	 */
	public Integer getMaxHouseArea() {
		return maxHouseArea;
	}
	/**
	 * 设置：所属楼层
	 */
	public void setStorey(Integer storey) {
		this.storey = storey;
	}
	/**
	 * 获取：所属楼层
	 */
	public Integer getStorey() {
		return storey;
	}
	/**
	 * 设置：分类（1、写字楼、2 新房 3、共享办公、4租房）
	 */
	public void setHouseType(Integer houseType) {
		this.houseType = houseType;
	}
	/**
	 * 获取：分类（1、写字楼、2 新房 3、共享办公、4租房）
	 */
	public Integer getHouseType() {
		return houseType;
	}
	/**
	 * 设置：状态 上架 下架（0下架、1上架）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 上架 下架（0下架、1上架）
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：文字详情
	 */
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	/**
	 * 获取：文字详情
	 */
	public String getDescribes() {
		return describes;
	}
	/**
	 * 设置：图片详情
	 */
	public void setIntroductionDetail(String introductionDetail) {
		this.introductionDetail = introductionDetail;
	}
	/**
	 * 获取：图片详情
	 */
	public String getIntroductionDetail() {
		return introductionDetail;
	}
	/**
	 * 设置：所在小区
	 */
	public void setVillage(String village) {
		this.village = village;
	}
	/**
	 * 获取：所在小区
	 */
	public String getVillage() {
		return village;
	}
	/**
	 * 设置：地址
	 */
	public void setAddesses(String addesses) {
		this.addesses = addesses;
	}
	/**
	 * 获取：地址
	 */
	public String getAddesses() {
		return addesses;
	}
	/**
	 * 设置：房源，房屋来源(1房东、2中介)
	 */
	public void setHouseSources(Integer houseSources) {
		this.houseSources = houseSources;
	}
	/**
	 * 获取：房源，房屋来源(1房东、2中介)
	 */
	public Integer getHouseSources() {
		return houseSources;
	}
	/**
	 * 设置：租房方式(0整租，1合租) 
	 */
	public void setRentWay(Integer rentWay) {
		this.rentWay = rentWay;
	}
	/**
	 * 获取：租房方式(0整租，1合租) 
	 */
	public Integer getRentWay() {
		return rentWay;
	}
	/**
	 * 设置：建筑面积（新楼盘需要）
	 */
	public void setBuildArea(String buildArea) {
		this.buildArea = buildArea;
	}
	/**
	 * 获取：建筑面积（新楼盘需要）
	 */
	public String getBuildArea() {
		return buildArea;
	}
	/**
	 * 设置：开盘时间（新楼盘需要）
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	/**
	 * 获取：开盘时间（新楼盘需要）
	 */
	public Date getOpenDate() {
		return openDate;
	}
	/**
	 * 设置：入住时间（新楼盘需要）
	 */
	public void setIntoDate(Date intoDate) {
		this.intoDate = intoDate;
	}
	/**
	 * 获取：入住时间（新楼盘需要）
	 */
	public Date getIntoDate() {
		return intoDate;
	}
	/**
	 * 设置：经度
	 */
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	/**
	 * 获取：经度
	 */
	public BigDecimal getLng() {
		return lng;
	}
	/**
	 * 设置：维度
	 */
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	/**
	 * 获取：维度
	 */
	public BigDecimal getLat() {
		return lat;
	}
	/**
	 * 设置：省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：县、区
	 */
	public void setCounty(String county) {
		this.county = county;
	}
	/**
	 * 获取：县、区
	 */
	public String getCounty() {
		return county;
	}
	/**
	 * 设置：乡、镇
	 */
	public void setTowns(String towns) {
		this.towns = towns;
	}
	/**
	 * 获取：乡、镇
	 */
	public String getTowns() {
		return towns;
	}
	/**
	 * 设置：发布人ID
	 */
	public void setPubUser(Long pubUser) {
		this.pubUser = pubUser;
	}
	/**
	 * 获取：发布人ID
	 */
	public Long getPubUser() {
		return pubUser;
	}
	/**
	 * 设置：标签
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
	/**
	 * 获取：标签
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * 设置：特色
	 */
	public void setFeatures(String features) {
		this.features = features;
	}
	/**
	 * 获取：特色
	 */
	public String getFeatures() {
		return features;
	}
	/**
	 * 设置：装修
	 */
	public void setFitup(String fitup) {
		this.fitup = fitup;
	}
	/**
	 * 获取：装修
	 */
	public String getFitup() {
		return fitup;
	}
	/**
	 * 设置：房型
	 */
	public void setHouseClasss(String houseClasss) {
		this.houseClasss = houseClasss;
	}
	/**
	 * 获取：房型
	 */
	public String getHouseClasss() {
		return houseClasss;
	}
	/**
	 * 设置：特价房（0否，1是）
	 */
	public void setSpecifyes(String specifyes) {
		this.specifyes = specifyes;
	}
	/**
	 * 获取：特价房（0否，1是）
	 */
	public String getSpecifyes() {
		return specifyes;
	}
	/**
	 * 设置：最新（0否，1是）
	 */
	public void setLatest(String latest) {
		this.latest = latest;
	}
	/**
	 * 获取：最新（0否，1是）
	 */
	public String getLatest() {
		return latest;
	}
	/**
	 * 设置：物业类型
	 */
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	/**
	 * 获取：物业类型
	 */
	public String getPropertyType() {
		return propertyType;
	}

    public String getRentable() {
        return rentable;
    }

    public void setRentable(String rentable) {
        this.rentable = rentable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getModifyMan() {
        return modifyMan;
    }

    public void setModifyMan(Long modifyMan) {
        this.modifyMan = modifyMan;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getCreateMan() {
        return createMan;
    }

    public void setCreateMan(Long createMan) {
        this.createMan = createMan;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBaseServicer() {
        return baseServicer;
    }

    public void setBaseServicer(String baseServicer) {
        this.baseServicer = baseServicer;
    }

    public String getEnterpriseServicer() {
        return enterpriseServicer;
    }

    public void setEnterpriseServicer(String enterpriseServicer) {
        this.enterpriseServicer = enterpriseServicer;
    }
}
