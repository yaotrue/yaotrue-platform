/*
 * Copyright 1999-2017 YaoTrue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yaotrue.redis;

import java.io.Serializable;
import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2018年1月19日 下午2:15:20
 */
public class Taobaoke implements Serializable {

	/**
	 * <code>{@value}</code>
	 */
	private static final long serialVersionUID = 8911839608084484884L;

	@Field("id")
	private String id;
	
	@Field("item_name")
	private String itemName;
	
	@Field("item_image")
	private String itemImage;
	
	@Field("item_category")
	private String itemCategory;
	
	@Field("item_original_url")
	private String itemOriginalUrl;
	
	@Field("item_price")
	private Double itemPrice;
	
	@Field("item_sales")
	private Integer itemSales;
	
	@Field("item_taobaoke_url")
	private String itemTbkUrl;
	
	@Field("platform_type")
	private String platformType;
	
	@Field("shouru_bili")
	private Double shouruBili;
	
	@Field("yongjin")
	private Double yongjin;
	
	@Field("seller_id")
	private String sellerId;
	
	@Field("seller_name")
	private String sellerName;
	
	@Field("shop_name")
	private String shopName;
	
	@Field("coupon_id")
	private String couponId;
	
	@Field("coupon_begin_time")
	private Date couponBeginTime;
	
	@Field("coupon_end_time")
	private Date couponEndTime;
	
	@Field("coupon_mark")
	private String couponMark;
	
	@Field("coupon_original_url")
	private String couponOriginalUrl;
	
	@Field("coupon_taobaoke_url")
	private String couponTbkUrl;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemImage
	 */
	public String getItemImage() {
		return itemImage;
	}

	/**
	 * @param itemImage
	 *            the itemImage to set
	 */
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	/**
	 * @return the itemCategory
	 */
	public String getItemCategory() {
		return itemCategory;
	}

	/**
	 * @param itemCategory the itemCategory to set
	 */
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	/**
	 * @return the itemOriginalUrl
	 */
	public String getItemOriginalUrl() {
		return itemOriginalUrl;
	}

	/**
	 * @param itemOriginalUrl
	 *            the itemOriginalUrl to set
	 */
	public void setItemOriginalUrl(String itemOriginalUrl) {
		this.itemOriginalUrl = itemOriginalUrl;
	}

	/**
	 * @return the itemPrice
	 */
	public Double getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice
	 *            the itemPrice to set
	 */
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the itemSales
	 */
	public Integer getItemSales() {
		return itemSales;
	}

	/**
	 * @param itemSales
	 *            the itemSales to set
	 */
	public void setItemSales(Integer itemSales) {
		this.itemSales = itemSales;
	}

	/**
	 * @return the itemTbkUrl
	 */
	public String getItemTbkUrl() {
		return itemTbkUrl;
	}

	/**
	 * @param itemTbkUrl
	 *            the itemTbkUrl to set
	 */
	public void setItemTbkUrl(String itemTbkUrl) {
		this.itemTbkUrl = itemTbkUrl;
	}

	/**
	 * @return the platformType
	 */
	public String getPlatformType() {
		return platformType;
	}

	/**
	 * @param platformType
	 *            the platformType to set
	 */
	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}

	/**
	 * @return the shouruBili
	 */
	public Double getShouruBili() {
		return shouruBili;
	}

	/**
	 * @param shouruBili
	 *            the shouruBili to set
	 */
	public void setShouruBili(Double shouruBili) {
		this.shouruBili = shouruBili;
	}

	/**
	 * @return the yongjin
	 */
	public Double getYongjin() {
		return yongjin;
	}

	/**
	 * @param yongjin
	 *            the yongjin to set
	 */
	public void setYongjin(Double yongjin) {
		this.yongjin = yongjin;
	}

	/**
	 * @return the sellerId
	 */
	public String getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId
	 *            the sellerId to set
	 */
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * @return the sellerName
	 */
	public String getSellerName() {
		return sellerName;
	}

	/**
	 * @param sellerName
	 *            the sellerName to set
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName
	 *            the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the couponId
	 */
	public String getCouponId() {
		return couponId;
	}

	/**
	 * @param couponId
	 *            the couponId to set
	 */
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	/**
	 * @return the couponBeginTime
	 */
	public Date getCouponBeginTime() {
		return couponBeginTime;
	}

	/**
	 * @param couponBeginTime
	 *            the couponBeginTime to set
	 */
	public void setCouponBeginTime(Date couponBeginTime) {
		this.couponBeginTime = couponBeginTime;
	}

	/**
	 * @return the couponEndTime
	 */
	public Date getCouponEndTime() {
		return couponEndTime;
	}

	/**
	 * @param couponEndTime
	 *            the couponEndTime to set
	 */
	public void setCouponEndTime(Date couponEndTime) {
		this.couponEndTime = couponEndTime;
	}

	/**
	 * @return the couponMark
	 */
	public String getCouponMark() {
		return couponMark;
	}

	/**
	 * @param couponMark
	 *            the couponMark to set
	 */
	public void setCouponMark(String couponMark) {
		this.couponMark = couponMark;
	}

	/**
	 * @return the couponOriginalUrl
	 */
	public String getCouponOriginalUrl() {
		return couponOriginalUrl;
	}

	/**
	 * @param couponOriginalUrl
	 *            the couponOriginalUrl to set
	 */
	public void setCouponOriginalUrl(String couponOriginalUrl) {
		this.couponOriginalUrl = couponOriginalUrl;
	}

	/**
	 * @return the couponTbkUrl
	 */
	public String getCouponTbkUrl() {
		return couponTbkUrl;
	}

	/**
	 * @param couponTbkUrl
	 *            the couponTbkUrl to set
	 */
	public void setCouponTbkUrl(String couponTbkUrl) {
		this.couponTbkUrl = couponTbkUrl;
	}
}
