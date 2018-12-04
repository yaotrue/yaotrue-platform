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
package com.yaotrue.solr;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.beans.Field;


/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2017年4月20日 下午2:01:49
 */
public class ITItemDoc implements Serializable{

	/**
	 * <code>{@value}</code>
	 */
	private static final long serialVersionUID = 6045804236853821821L;
	
	/**
	 * 商品标识
	 */
	@Field(ItemDocField.ID)
	private Long id;
	/**
	 * 店铺ID
	 */
	@Field(ItemDocField.STORE_ID)
	private Long storeId;
	/**
	 * 渠道ID
	 */
	@Field(ItemDocField.CHANNEL_ID)
	private List<Long> channelId;
	
	/**
	 * 商品编码
	 */
	@Field(ItemDocField.CODE)
	private String code;
	
	/**
	 * 商品款式
	 */
	@Field("style")
	private String style;
	
	/**
	 * 商品在分组中的排序
	 */
	@Field("sort_no")
	private Integer sortNo;
	
	/**
	 * 关键字
	 */
	@Field(ItemDocField.KEYWORDS)
	private List<String> keywords;
	
	/**
	 * 吊牌价
	 */
	@Field(ItemDocField.LIST_PRICE)
	private Double listPrice;
	/**
	 * 销售价
	 */
	@Field(ItemDocField.SALE_PRICE)
	private Double salePrice;
	/**
	 * 上架时间
	 */
	@Field(ItemDocField.LIST_TIME)
	private Date listTime;
	
	/**
	 * 最近更新时间
	 */
	@Field(ItemDocField.LAST_MODIFIED)
	private Date lastModified;
	
	/**
	 * 定时上架时间
	 */
	@Field(ItemDocField.ACTIVE_START_TIME)
	private Date activeStartTime;
	
	/**
	 * 定时上架时间
	 */
	@Field(ItemDocField.ACTIVE_END_TIME)
	private Date activeEndTime;
	
	/**
	 * 销售量
	 */
	@Field(ItemDocField.SALES)
	private Integer sales;
	/**
	 * 商品评分
	 */
	@Field(ItemDocField.RANK)
	private Double rank;
	/**
	 * 浏览量
	 */
	@Field(ItemDocField.PAGEVIEW)
	private Integer pageview;
	/**
	 * 商品收藏量
	 */
	@Field(ItemDocField.FAVORE)
	private Integer favore;
	/**
	 * 库存
	 */
	@Field(ItemDocField.STOCK)
	private Integer stock;
	/**
	 * 商品Tag 可以用来对商品做各种控制
	 */
	@Field(ItemDocField.TAG)
	private List<String> tag;
	/**
	 * 属性id
	 */
	@Field(ItemDocField.PROPERTY_VALUE_ID)
	private List<Long> propertyValueId;
	
	/**
	 * 后台分类
	 */
	@Field(ItemDocField.CATEGORY_ID)
	private List<Long> categoryId;
	/**
	 * 分类编码
	 */
	@Field(ItemDocField.CATEGORY_CODE)
	private List<String> categoryCode;
	/**
	 * 前端导航
	 */
	@Field(ItemDocField.NAVIGATION_ID)
	private List<Long> navigationId;
	
	/**
	 * 品牌
	 */
	@Field("brand_id")
	private List<Long> brandId;
	
	@Field("brand_code")
	private List<String> brandCode;
	
	/** 拼音全拼 汉字在后**/
	@Field("pinyin_a")
	private List<String> pinyinAllList_A;
	
	/** 拼音全拼 汉字在前**/
	@Field("pinyin_b")
	private List<String> pinyinAllList_B;
	
	/**
	 * 分类排序
	 */
	@Field(ItemDocField.CATEGORY_ORDER)
	private Map<String, Double> categoryOrder = new HashMap<String, Double>(0);
	
	/**
	 * 导航排序
	 */
	@Field(ItemDocField.NAVIGATION_ORDER)
	private Map<String, Double> navigationOrder = new HashMap<String, Double>(0);
	
	/**
	 * 国际化分类名
	 */
	@Field("dynamic_category_name_*")
	private Map<String, List<String>> dynamicCategoryNameMap;
	
	/**
	 * 国际化属性值
	 */
	@Field("dynamic_property_value_name_*")
	private Map<String, List<String>> dynamicPropertyValueMap;
	
	/**
	 * 国际化品牌名
	 */
	@Field("dynamic_brand_name_*")
	private Map<String, String> dynamicBrandNameMap;
	
	/**
	 * 国际化商品名
	 */
	@Field("dynamic_title_*")
	private Map<String, String> dynamicTitleMap;
	
	/**
	 * 国际化商品副标题
	 */
	@Field("dynamic_subTitle_*")
	private Map<String, String> dynamicSubTitleMap;
	
	/**
	 * 国际化概述
	 */
	@Field("dynamic_sketch_*")
	private Map<String, String> dynamicSketchMap;
	
	/**
	 * 国际化详细描述
	 */
	@Field("dynamic_description_*")
	private Map<String, String> dynamicDescriptionMap;
	
	/**
	 * 国际化SEO Title
	 */
	@Field("dynamic_seoTitle_*")
	private Map<String, String> dynamicSeoTitleMap;
	
	/**
	 * 国际化SEO Keywords
	 */
	@Field("dynamic_seoKeywords_*")
	private Map<String, String> dynamicSeoKeywordsMap;
	
	/**
	 * 国际化SEO Description
	 */
	@Field("dynamic_seoDescription_*")
	private Map<String, String> dynamicSeoDescriptionMap;

	
	/**
	 * @return the id
	 */
	public Long getId(){
		return id;
	}

	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id){
		this.id = id;
	}

	
	/**
	 * @return the storeId
	 */
	public Long getStoreId(){
		return storeId;
	}

	
	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(Long storeId){
		this.storeId = storeId;
	}

	
	/**
	 * @return the channelId
	 */
	public List<Long> getChannelId(){
		return channelId;
	}

	
	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(List<Long> channelId){
		this.channelId = channelId;
	}

	
	/**
	 * @return the code
	 */
	public String getCode(){
		return code;
	}

	
	/**
	 * @param code the code to set
	 */
	public void setCode(String code){
		this.code = code;
	}

	
	
	/**
	 * @return the style
	 */
	public String getStyle(){
		return style;
	}


	
	/**
	 * @param style the style to set
	 */
	public void setStyle(String style){
		this.style = style;
	}


	
	/**
	 * @return the sortNo
	 */
	public Integer getSortNo(){
		return sortNo;
	}


	
	/**
	 * @param sortNo the sortNo to set
	 */
	public void setSortNo(Integer sortNo){
		this.sortNo = sortNo;
	}


	/**
	 * @return the keywords
	 */
	public List<String> getKeywords(){
		return keywords;
	}

	
	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<String> keywords){
		this.keywords = keywords;
	}

	
	/**
	 * @return the listPrice
	 */
	public Double getListPrice(){
		return listPrice;
	}

	
	/**
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(Double listPrice){
		this.listPrice = listPrice;
	}

	
	/**
	 * @return the salePrice
	 */
	public Double getSalePrice(){
		return salePrice;
	}

	
	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(Double salePrice){
		this.salePrice = salePrice;
	}

	
	/**
	 * @return the listTime
	 */
	public Date getListTime(){
		return listTime;
	}

	
	/**
	 * @param listTime the listTime to set
	 */
	public void setListTime(Date listTime){
		this.listTime = listTime;
	}

	
	/**
	 * @return the lastModified
	 */
	public Date getLastModified(){
		return lastModified;
	}

	
	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Date lastModified){
		this.lastModified = lastModified;
	}

	
	/**
	 * @return the activeStartTime
	 */
	public Date getActiveStartTime(){
		return activeStartTime;
	}

	
	/**
	 * @param activeStartTime the activeStartTime to set
	 */
	public void setActiveStartTime(Date activeStartTime){
		this.activeStartTime = activeStartTime;
	}

	
	/**
	 * @return the activeEndTime
	 */
	public Date getActiveEndTime(){
		return activeEndTime;
	}

	
	/**
	 * @param activeEndTime the activeEndTime to set
	 */
	public void setActiveEndTime(Date activeEndTime){
		this.activeEndTime = activeEndTime;
	}

	
	/**
	 * @return the sales
	 */
	public Integer getSales(){
		return sales;
	}

	
	/**
	 * @param sales the sales to set
	 */
	public void setSales(Integer sales){
		this.sales = sales;
	}

	
	/**
	 * @return the rank
	 */
	public Double getRank(){
		return rank;
	}

	
	/**
	 * @param rank the rank to set
	 */
	public void setRank(Double rank){
		this.rank = rank;
	}

	
	/**
	 * @return the pageview
	 */
	public Integer getPageview(){
		return pageview;
	}

	
	/**
	 * @param pageview the pageview to set
	 */
	public void setPageview(Integer pageview){
		this.pageview = pageview;
	}

	
	/**
	 * @return the favore
	 */
	public Integer getFavore(){
		return favore;
	}

	
	/**
	 * @param favore the favore to set
	 */
	public void setFavore(Integer favore){
		this.favore = favore;
	}

	
	/**
	 * @return the stock
	 */
	public Integer getStock(){
		return stock;
	}

	
	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock){
		this.stock = stock;
	}

	
	/**
	 * @return the tag
	 */
	public List<String> getTag(){
		return tag;
	}

	
	/**
	 * @param tag the tag to set
	 */
	public void setTag(List<String> tag){
		this.tag = tag;
	}

	
	/**
	 * @return the propertyValueId
	 */
	public List<Long> getPropertyValueId(){
		return propertyValueId;
	}

	
	/**
	 * @param propertyValueId the propertyValueId to set
	 */
	public void setPropertyValueId(List<Long> propertyValueId){
		this.propertyValueId = propertyValueId;
	}

	
	/**
	 * @return the categoryId
	 */
	public List<Long> getCategoryId(){
		return categoryId;
	}

	
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(List<Long> categoryId){
		this.categoryId = categoryId;
	}

	
	/**
	 * @return the categoryCode
	 */
	public List<String> getCategoryCode(){
		return categoryCode;
	}

	
	/**
	 * @param categoryCode the categoryCode to set
	 */
	public void setCategoryCode(List<String> categoryCode){
		this.categoryCode = categoryCode;
	}

	
	/**
	 * @return the navigationId
	 */
	public List<Long> getNavigationId(){
		return navigationId;
	}

	
	/**
	 * @param navigationId the navigationId to set
	 */
	public void setNavigationId(List<Long> navigationId){
		this.navigationId = navigationId;
	}

	
	/**
	 * @return the brandId
	 */
	public List<Long> getBrandId(){
		return brandId;
	}

	
	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(List<Long> brandId){
		this.brandId = brandId;
	}

	
	/**
	 * @return the brandCode
	 */
	public List<String> getBrandCode(){
		return brandCode;
	}

	
	/**
	 * @param brandCode the brandCode to set
	 */
	public void setBrandCode(List<String> brandCode){
		this.brandCode = brandCode;
	}

	
	/**
	 * @return the pinyinAllList_A
	 */
	public List<String> getPinyinAllList_A(){
		return pinyinAllList_A;
	}

	
	/**
	 * @param pinyinAllList_A the pinyinAllList_A to set
	 */
	public void setPinyinAllList_A(List<String> pinyinAllList_A){
		this.pinyinAllList_A = pinyinAllList_A;
	}

	
	/**
	 * @return the pinyinAllList_B
	 */
	public List<String> getPinyinAllList_B(){
		return pinyinAllList_B;
	}

	
	/**
	 * @param pinyinAllList_B the pinyinAllList_B to set
	 */
	public void setPinyinAllList_B(List<String> pinyinAllList_B){
		this.pinyinAllList_B = pinyinAllList_B;
	}

	
	/**
	 * @return the categoryOrder
	 */
	public Map<String, Double> getCategoryOrder(){
		return categoryOrder;
	}

	
	/**
	 * @param categoryOrder the categoryOrder to set
	 */
	public void setCategoryOrder(Map<String, Double> categoryOrder){
		this.categoryOrder = categoryOrder;
	}

	
	/**
	 * @return the navigationOrder
	 */
	public Map<String, Double> getNavigationOrder(){
		return navigationOrder;
	}

	
	/**
	 * @param navigationOrder the navigationOrder to set
	 */
	public void setNavigationOrder(Map<String, Double> navigationOrder){
		this.navigationOrder = navigationOrder;
	}

	
	/**
	 * @return the dynamicCategoryNameMap
	 */
	public Map<String, List<String>> getDynamicCategoryNameMap(){
		return dynamicCategoryNameMap;
	}

	
	/**
	 * @param dynamicCategoryNameMap the dynamicCategoryNameMap to set
	 */
	public void setDynamicCategoryNameMap(Map<String, List<String>> dynamicCategoryNameMap){
		this.dynamicCategoryNameMap = dynamicCategoryNameMap;
	}

	
	/**
	 * @return the dynamicPropertyValueMap
	 */
	public Map<String, List<String>> getDynamicPropertyValueMap(){
		return dynamicPropertyValueMap;
	}

	
	/**
	 * @param dynamicPropertyValueMap the dynamicPropertyValueMap to set
	 */
	public void setDynamicPropertyValueMap(Map<String, List<String>> dynamicPropertyValueMap){
		this.dynamicPropertyValueMap = dynamicPropertyValueMap;
	}

	
	/**
	 * @return the dynamicBrandNameMap
	 */
	public Map<String, String> getDynamicBrandNameMap(){
		return dynamicBrandNameMap;
	}

	
	/**
	 * @param dynamicBrandNameMap the dynamicBrandNameMap to set
	 */
	public void setDynamicBrandNameMap(Map<String, String> dynamicBrandNameMap){
		this.dynamicBrandNameMap = dynamicBrandNameMap;
	}

	
	/**
	 * @return the dynamicTitleMap
	 */
	public Map<String, String> getDynamicTitleMap(){
		return dynamicTitleMap;
	}

	
	/**
	 * @param dynamicTitleMap the dynamicTitleMap to set
	 */
	public void setDynamicTitleMap(Map<String, String> dynamicTitleMap){
		this.dynamicTitleMap = dynamicTitleMap;
	}

	
	/**
	 * @return the dynamicSubTitleMap
	 */
	public Map<String, String> getDynamicSubTitleMap(){
		return dynamicSubTitleMap;
	}

	
	/**
	 * @param dynamicSubTitleMap the dynamicSubTitleMap to set
	 */
	public void setDynamicSubTitleMap(Map<String, String> dynamicSubTitleMap){
		this.dynamicSubTitleMap = dynamicSubTitleMap;
	}

	
	/**
	 * @return the dynamicSketchMap
	 */
	public Map<String, String> getDynamicSketchMap(){
		return dynamicSketchMap;
	}

	
	/**
	 * @param dynamicSketchMap the dynamicSketchMap to set
	 */
	public void setDynamicSketchMap(Map<String, String> dynamicSketchMap){
		this.dynamicSketchMap = dynamicSketchMap;
	}

	
	/**
	 * @return the dynamicDescriptionMap
	 */
	public Map<String, String> getDynamicDescriptionMap(){
		return dynamicDescriptionMap;
	}

	
	/**
	 * @param dynamicDescriptionMap the dynamicDescriptionMap to set
	 */
	public void setDynamicDescriptionMap(Map<String, String> dynamicDescriptionMap){
		this.dynamicDescriptionMap = dynamicDescriptionMap;
	}

	
	/**
	 * @return the dynamicSeoTitleMap
	 */
	public Map<String, String> getDynamicSeoTitleMap(){
		return dynamicSeoTitleMap;
	}

	
	/**
	 * @param dynamicSeoTitleMap the dynamicSeoTitleMap to set
	 */
	public void setDynamicSeoTitleMap(Map<String, String> dynamicSeoTitleMap){
		this.dynamicSeoTitleMap = dynamicSeoTitleMap;
	}

	
	/**
	 * @return the dynamicSeoKeywordsMap
	 */
	public Map<String, String> getDynamicSeoKeywordsMap(){
		return dynamicSeoKeywordsMap;
	}

	
	/**
	 * @param dynamicSeoKeywordsMap the dynamicSeoKeywordsMap to set
	 */
	public void setDynamicSeoKeywordsMap(Map<String, String> dynamicSeoKeywordsMap){
		this.dynamicSeoKeywordsMap = dynamicSeoKeywordsMap;
	}

	
	/**
	 * @return the dynamicSeoDescriptionMap
	 */
	public Map<String, String> getDynamicSeoDescriptionMap(){
		return dynamicSeoDescriptionMap;
	}

	
	/**
	 * @param dynamicSeoDescriptionMap the dynamicSeoDescriptionMap to set
	 */
	public void setDynamicSeoDescriptionMap(Map<String, String> dynamicSeoDescriptionMap){
		this.dynamicSeoDescriptionMap = dynamicSeoDescriptionMap;
	}

}
