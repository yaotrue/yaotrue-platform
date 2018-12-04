/**
 * Copyright (c) 2015 YaoTrue All Rights Reserved.
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
*/
package com.yaotrue.solr;

/**
 * @author D.C
 */
public interface ItemDocField extends ItemDocStoredField {
	/**
	 * 店铺ID
	 */
	String STORE_ID = "store_id";
	/**
	 * 商品款号
	 */
	String STYLE = "style";
	/**
	 * 同款排序号
	 */
	String SORT_NO = "sort_no";
	/**
	 * 渠道ID
	 */
	String CHANNEL_ID = "channel_id";
	/**
	 * 语言ID
	 */
	String LANGUAGE_ID = "language_id";
	/**
	 * 副标题
	 */
	String SUBTITLE = "subtitle";
	/**
	 * 商品概述
	 */
	String SKETCH = "sketch";
	/**
	 * 商品详述
	 */
	String DESCRIPTION = "description";
	/**
	 * 分组字段
	 */
	String GROUP_FIELD = "group_field";
	/**
	 * 商品默认排序的分数 (分数从大到小)
	 */
	String DEFAULT_SCORE = "default_score";
	/**
	 * 上架时间
	 */
	String LIST_TIME = "list_time";
	
	/**
	 * 定时上架时间
	 */
	String ACTIVE_START_TIME = "active_start_time";
	/**
	 * 定时下架时间
	 */
	String ACTIVE_END_TIME = "active_end_time";
	
	/**
	 * 最近更新时间
	 */
	String LAST_MODIFIED = "last_modified";
	/**
	 * 属性值
	 */
	String PROPERTY_VALUE_NAME = "property_value_name";
	/**
	 * 后台分类
	 */
	String CATEGORY_ID = "category_id";
	String CATEGORY_CODE = "category_code";
	String CATEGORY_NAME = "category_name";
	String CATEGORY_ORDER = "category_order";
	
	/**
	 * 品牌ID
	 */
	String BRAND_ID = "brand_id";
	/**
	 * 品牌编码
	 */
	String BRAND_CODE = "brand_code";
	
	/**
	 * 前端导航
	 */
	String NAVIGATION_ID = "navigation_id";
	String NAVIGATION_CODE = "navigation_code";
	String NAVIGATION_NAME = "navigation_name";
	String NAVIGATION_ORDER = "navigation_order";
	
	/**
	 * 动态字段
	 */
	String DYNAMIC_CATEGORY_NAME = "dynamic_category_name_*";
	String DYNAMIC_PROPERTY_VALUE_NAME = "dynamic_property_value_name_*";
	String DYNAMIC_BRAND_NAME = "dynamic_brand_name_*";
	String DYNAMIC_TITLE = "dynamic_title_*";
	String DYNAMIC_DESCRIPTION = "dynamic_description_*";
	String DYNAMIC_SEOTITLE = "dynamic_seoTitle_*";
	String DYNAMIC_SEOKEYWORDS = "dynamic_seoKeywords_*";
	String DYNAMIC_SEODESCRIPTION = "dynamic_seoDescription_*";
	
	/**
	 * 默认复制字段
	 */
	String TEXT = "text";
}
