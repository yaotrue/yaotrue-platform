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
public interface ItemDocStoredField {
	
	/**
	 * 商品标识
	 */
	String ID = "id";
	/**
	 * 商品编码
	 */
	String CODE = "code";
	/**
	 * 关键字
	 */
	String KEYWORDS = "keywords";
	/**
	 * 商品名称
	 */
	String TITLE = "title";
	/**
	 * 图片
	 */
	String IMAGE = "image";
	/**
	 * 图片Alt
	 */
	String IMAGE_ALT = "image_alt";
	/**
	 * 活动ICON
	 */
	String PROMOTION_ICON = "promotion_icon";

	/**
	 * 吊牌价
	 */
	String LIST_PRICE = "list_price";
	/**
	 * 销售价
	 */
	String SALE_PRICE = "sale_price";
	/**
	 * 销售量
	 */
	String SALES = "sales";
	/**
	 * 商品评分
	 */
	String RANK = "rank";
	/**
	 * 浏览量
	 */
	String PAGEVIEW = "pageview";
	/**
	 * 商品收藏量
	 */
	String FAVORE = "favore";
	/**
	 * 库存
	 */
	String STOCK = "stock";
	/**
	 * 商品Tag 可以用来对商品做各种控制
	 */
	String TAG = "tag";
	/**
	 * 属性id
	 */
	String PROPERTY_VALUE_ID = "property_value_id";
	/**
	 * 拼音汉字在前
	 */
	String PINYIN_B = "pinyin_b";
	/**
	 * 拼音汉字在后
	 */
	String PINYIN_A = "pinyin_a";
	/**
	 * 提示
	 */
	String SUGGESTION = "suggestion";
}
