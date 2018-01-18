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
package com.yaotrue.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SolrPingResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yaotrue.BaseTest;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年7月12日 下午12:52:18
 */
public class SolrTest extends BaseTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SolrTest.class);

	@Autowired
	private SolrClient solrClient;
	
	@Test
	public void testSolr(){
		try {
			SolrPingResponse solrPingResponse = solrClient.ping();
			logger.info("----------solr status:{}",solrPingResponse.getStatus());
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIndex() throws IOException, SolrServerException {
		for (int i = 1; i <= 100; i++) {
			ITItemDoc itItemDoc = new ITItemDoc();
			itItemDoc.setId(Long.valueOf(i));
			itItemDoc.setStoreId(1L);
			itItemDoc.setChannelId(Arrays.asList(new Long[]{1L,2L}));
			itItemDoc.setCode("code"+i);
			itItemDoc.setKeywords(Arrays.asList(new String[]{"巨石强森","男士UA","Brahma "}));
			itItemDoc.setListPrice(new Double(200+i));
			itItemDoc.setSalePrice(new Double(180+i));
			itItemDoc.setListTime(new Date());
			itItemDoc.setLastModified(new Date());
			itItemDoc.setSales(10+i);
			itItemDoc.setRank(new Double(1.2+i));
			itItemDoc.setPageview(100+i);
			itItemDoc.setFavore(120+i);
			itItemDoc.setStock(2+i);
			itItemDoc.setTag(Arrays.asList(new String[]{"TAG1","TAG2"}));
			itItemDoc.setPropertyValueId(Arrays.asList(new Long[]{1L,2L}));
			itItemDoc.setCategoryCode(Arrays.asList(new String[]{"ccode1","ccode2"}));
			itItemDoc.setCategoryId(Arrays.asList(new Long[]{1L,2L}));
			itItemDoc.setNavigationId(Arrays.asList(new Long[]{1L,2L}));
			itItemDoc.setBrandId(Arrays.asList(new Long[]{1L,2L}));
			itItemDoc.setBrandCode(Arrays.asList(new String[]{"bcode1","bcode2"}));
			itItemDoc.setPinyinAllList_A(Arrays.asList(new String[]{"pinyinA1","pinyinA2"}));
			itItemDoc.setPinyinAllList_B(Arrays.asList(new String[]{"pinyinB1","pinyinB2"}));
			itItemDoc.setStyle("style"+i);
			itItemDoc.setSortNo(i);
			
			Map<String, Double> categoryOrder = new HashMap<>();
			categoryOrder.put("category_order_"+1, 1.6);
			
			Map<String, Double> navigationOrde = new HashMap<>();
			navigationOrde.put("navigation_order_"+1, 1.6);
			itItemDoc.setCategoryOrder(categoryOrder);
			itItemDoc.setNavigationOrder(navigationOrde);
			
			Map<String, String> dynamicBrandNameMap = new HashMap<>();
			dynamicBrandNameMap.put("dynamic_brand_name_zh_CN", "中文品牌名1"+i);
			dynamicBrandNameMap.put("dynamic_brand_name_zh_HK", "中文繁體品牌名1"+i);
			itItemDoc.setDynamicBrandNameMap(dynamicBrandNameMap);
			
			Map<String, List<String>> dynamicCategoryNameMap = new HashMap<>();
			List<String> zhcncategoryNameList = new ArrayList<>();
			zhcncategoryNameList.add("中文分类名1"+i);
			zhcncategoryNameList.add("中文分类名2"+i);
			dynamicCategoryNameMap.put("dynamic_category_name_zh_CN", zhcncategoryNameList);
			List<String> zhhkcategoryNameList = new ArrayList<>();
			zhhkcategoryNameList.add("中文繁體分類名1"+i);
			zhhkcategoryNameList.add("中文繁體分類名2"+i);
			dynamicCategoryNameMap.put("dynamic_category_name_zh_HK", zhhkcategoryNameList);
			itItemDoc.setDynamicCategoryNameMap(dynamicCategoryNameMap);
			
			Map<String, String> dynamicTitleMap = new HashMap<>();
			dynamicTitleMap.put("dynamic_title_zh_CN", "商品中文名"+i);
			dynamicTitleMap.put("dynamic_title_zh_HK", "商品中文繁體名"+i);
			itItemDoc.setDynamicTitleMap(dynamicTitleMap);
			solrClient.addBean(itItemDoc);
		}
		
		solrClient.commit();
	}
	
	@Test
	public void testSeach() throws SolrServerException, IOException{
		SolrQuery solrQuery = new SolrQuery("*:*");
		QueryResponse queryResponse = solrClient.query(solrQuery);
		SolrDocumentList documentList = queryResponse.getResults();
		
		for (SolrDocument solrDocument : documentList) {
			System.out.println(solrDocument.getFieldValue("id"));
		}
	}
	
}
