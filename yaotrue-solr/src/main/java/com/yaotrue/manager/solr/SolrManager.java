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
package com.yaotrue.manager.solr;

import java.util.Map;

import com.yaotrue.command.Page;
import com.yaotrue.command.Pagination;
import com.yaotrue.model.solr.YaoTrueSku;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年11月1日 下午1:39:42
 */
public interface SolrManager {

	/**
	 * 全局更新Solr
	 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
	 * @since JDK 1.7
	 */
	void refreshSolr();
	
	/**
	 * 根据产品ID更新索引
	 *
	 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
	 * @param skuId
	 * @since JDK 1.7
	 */
	void refreshBySkuId(String skuId);
	
	/**
	 * 清空Solr
	 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
	 * @since JDK 1.7
	 */
	void deleteAll();
	
	/**
	 * 根据产品ID删除索引
	 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
	 * @param skuId
	 * @since JDK 1.7
	 */
	void deleteBySkuId(String skuId);
	
	/**
	 * 根据参数分页查询产品数据
	 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
	 * @param page
	 * @param params
	 * @return
	 * @since JDK 1.7
	 */
	Pagination<YaoTrueSku> findSkuByParams(Page page,Map<String, Object> params);
}
