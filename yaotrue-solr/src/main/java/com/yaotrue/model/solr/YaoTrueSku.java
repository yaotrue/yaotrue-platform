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
package com.yaotrue.model.solr;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

import com.yaotrue.model.BaseModel;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年11月1日 上午11:34:09
 */
public class YaoTrueSku extends BaseModel {

	/**
	 * <code>{@value}</code>
	 */
	private static final long serialVersionUID = -6017713866455962952L;
	
	@Field
	private Long id;
	
	/**商品ID*/
	@Field
	private String skuId;
	
	/**商品名*/
	@Field
	private String skuName;
	
	/**商品图片*/
	@Field
	private String skuImgUrl;
	
	/**商品详情页链接*/
	@Field
	private String skuDetailUrl;
	
	/**分类名*/
	@Field
	private String categoryName;
	
	/**推广链接*/
	@Field
	private String tgUrl;
	
	/**价格*/
	@Field
	private Double price;
	
	/**销售量*/
	@Field
	private Integer salesCount;
	
	/**收入比率*/
	@Field
	private Double incomeRate;
	
	/**佣金*/
	@Field
	private Double commission;
	
	/**店铺名*/
	@Field
	private String shopName;
	
	/**平台名*/
	@Field
	private String platformName;
	
	/**浏览量*/
	@Field
	private Integer viewCount;
	
	/**上线时间*/
	@Field
	private Date onLineTime;
	
	/**状态*/
	@Field
	private Integer status;

	/**
	 * @return the id
	 */
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
