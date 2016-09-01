/**
 * Copyright (c) 2012 Baozun All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Baozun.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Baozun.
 *
 * BAOZUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. BAOZUN SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */
package com.yaotrue.model.solr;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.beans.Field;

import com.yaotrue.model.BaseModel;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年7月12日 下午1:46:29
 */
public class YaoTrueSolrItem extends BaseModel {

	/**
	 * <code>{@value}</code>
	 */
	private static final long serialVersionUID = 7429456819596362203L;

	@Field
	private Long 				id;
	
	@Field
	private String				name;
	
	@Field
	private Double				listPrice;
	
	@Field
	private List<String> 		labels;
	
	@Field
	private String				title;

	@Field
	private String				keywords;

	@Field
	private String				description;
	
	@Field
	private Long				onShelvesTime;
	
	@Field
	private Integer				status;
	
	@Field("order_*")
	private Map<String, Long>	navOrdeMap;
	
	@Field
	private String[]			channels;
}
