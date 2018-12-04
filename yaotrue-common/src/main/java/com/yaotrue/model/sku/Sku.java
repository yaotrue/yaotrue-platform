/**
 * Copyright (c) 2012 YaoTrue All Rights Reserved.
 *
 * This software is the confidential and proprietary information of YaoTrue.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with YaoTrue.
 *
 * YaoTrue MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. YaoTrue SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */
package com.yaotrue.model.sku;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.yaotrue.model.BaseModel;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年11月1日 下午1:45:25
 */
@Entity  
@Table(name = "T_YT_SKU") 
public class Sku extends BaseModel {

	/**
	 * <code>{@value}</code>
	 */
	private static final long serialVersionUID = -1353168419579273950L;

	private Long id;
	
	/**商品ID*/
	private String skuId;
	
	/**商品名*/
	private String skuName;
	
	/**商品图片*/
	private String skuImgUrl;
	
	/**商品详情页链接*/
	private String skuDetailUrl;
	
	/**分类名*/
	private String categoryName;
	
	/**推广链接*/
	private String tgUrl;
	
	/**价格*/
	private Double price;
	
	/**销售量*/
	private Integer salesCount;
	
	/**收入比率*/
	private Double incomeRate;
	
	/**佣金*/
	private Double commission;
	
	/**店铺名*/
	private String shopName;
	
	/**平台名*/
	private String platformName;
	
	/**浏览量*/
	private Integer viewCount = 0;
	
	/**上线时间*/
	private Date onLineTime = new Date();
	
	/**状态*/
	private Integer status = 1;

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_T_YT_SKU",sequenceName = "S_T_YT_SKU",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_T_YT_SKU")
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the skuId
	 */
	@Column(name = "SKU_ID")
	public String getSkuId() {
		return skuId;
	}

	/**
	 * @param skuId the skuId to set
	 */
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	/**
	 * @return the skuName
	 */
	@Column(name = "SKU_NAME")
	public String getSkuName() {
		return skuName;
	}

	/**
	 * @param skuName the skuName to set
	 */
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	/**
	 * @return the skuImgUrl
	 */
	@Column(name = "SKU_IMG_URL")
	public String getSkuImgUrl() {
		return skuImgUrl;
	}

	/**
	 * @param skuImgUrl the skuImgUrl to set
	 */
	public void setSkuImgUrl(String skuImgUrl) {
		this.skuImgUrl = skuImgUrl;
	}

	/**
	 * @return the skuDetailUrl
	 */
	@Column(name = "SKU_DETAIL_URL")
	public String getSkuDetailUrl() {
		return skuDetailUrl;
	}

	/**
	 * @param skuDetailUrl the skuDetailUrl to set
	 */
	public void setSkuDetailUrl(String skuDetailUrl) {
		this.skuDetailUrl = skuDetailUrl;
	}

	/**
	 * @return the categoryName
	 */
	@Column(name = "CATEGORY_NAME")
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the tgUrl
	 */
	@Type(type = "text")
	@Column(name = "TG_URL")
	public String getTgUrl() {
		return tgUrl;
	}

	/**
	 * @param tgUrl the tgUrl to set
	 */
	public void setTgUrl(String tgUrl) {
		this.tgUrl = tgUrl;
	}

	/**
	 * @return the price
	 */
	@Column(name = "PRICE")
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the salesCount
	 */
	@Column(name = "SALES_COUNT")
	public Integer getSalesCount() {
		return salesCount;
	}

	/**
	 * @param salesCount the salesCount to set
	 */
	public void setSalesCount(Integer salesCount) {
		this.salesCount = salesCount;
	}

	/**
	 * @return the incomeRate
	 */
	@Column(name = "INCOME_RATE")
	public Double getIncomeRate() {
		return incomeRate;
	}

	/**
	 * @param incomeRate the incomeRate to set
	 */
	public void setIncomeRate(Double incomeRate) {
		this.incomeRate = incomeRate;
	}

	/**
	 * @return the commission
	 */
	@Column(name = "COMMISSION")
	public Double getCommission() {
		return commission;
	}

	/**
	 * @param commission the commission to set
	 */
	public void setCommission(Double commission) {
		this.commission = commission;
	}

	/**
	 * @return the shopName
	 */
	@Column(name = "SHOP_NAME")
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the platformName
	 */
	@Column(name = "PLATFORM_NAME")
	public String getPlatformName() {
		return platformName;
	}

	/**
	 * @param platformName the platformName to set
	 */
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	/**
	 * @return the viewCount
	 */
	@Column(name = "VIEW_COUNT")
	public Integer getViewCount() {
		return viewCount;
	}

	/**
	 * @param viewCount the viewCount to set
	 */
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	/**
	 * @return the onLineTime
	 */
	@Column(name = "ONLINE_TIME")
	public Date getOnLineTime() {
		return onLineTime;
	}

	/**
	 * @param onLineTime the onLineTime to set
	 */
	public void setOnLineTime(Date onLineTime) {
		this.onLineTime = onLineTime;
	}

	/**
	 * @return the status
	 */
	@Column(name = "STATUS")
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
