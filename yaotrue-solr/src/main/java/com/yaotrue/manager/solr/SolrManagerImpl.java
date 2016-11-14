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
package com.yaotrue.manager.solr;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yaotrue.command.Page;
import com.yaotrue.command.Pagination;
import com.yaotrue.dao.SkuDao;
import com.yaotrue.model.sku.Sku;
import com.yaotrue.model.solr.YaoTrueSku;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a> 2016年11月1日 下午3:59:40
 */
@Service
@Transactional
public class SolrManagerImpl implements SolrManager {

	@Autowired
	private SolrServer solrServer;

	@Autowired
	private SkuDao skuDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yaotrue.manager.solr.SolrManager#refreshSolr()
	 */
	@Override
	@Transactional(readOnly = true)
	public void refreshSolr() {
		List<Sku> skus = skuDao.findAllSku();

		List<YaoTrueSku> yaoTrueSkus = toYaotrueSku(skus);

		if(null == yaoTrueSkus || yaoTrueSkus.size() == 0){
			return;
		}
		
		try {
			solrServer.addBeans(yaoTrueSkus);
			solrServer.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 数据类型转换
	 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
	 * @param skus
	 * @return
	 * @since JDK 1.7
	 */
	private List<YaoTrueSku> toYaotrueSku(List<Sku> skus) {
		if(null == skus || skus.size() == 0){
			return null;
		}
		
		List<YaoTrueSku> yaoTrueSkus = new ArrayList<YaoTrueSku>();
		for (Sku sku : skus) {
			YaoTrueSku yaoTrueSku = new YaoTrueSku();
			try {
				BeanUtils.copyProperties(yaoTrueSku, sku);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			yaoTrueSkus.add(yaoTrueSku);
		}
		return yaoTrueSkus;
	}

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.solr.SolrManager#findSkuByParams(com.yaotrue.command.Page, java.util.Map)
	 */
	@Override
	@Transactional(readOnly = true)
	public Pagination<YaoTrueSku> findSkuByParams(Page page, Map<String, Object> params) {
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("*:*");
		if(null != params){
			if(null != params.get("keyword")){
				solrQuery.addFilterQuery("testIk:"+(String)params.get("keyword"));
			}
		}
		
		solrQuery.setStart(page.getStart()).setRows(page.getSize());
		
		try {
			QueryResponse rResponse = solrServer.query(solrQuery);
			Pagination<YaoTrueSku> pagination = new Pagination<YaoTrueSku>();		
			pagination.setCount(rResponse.getResults().getNumFound());
			pagination.setCurrentPage((page.getStart()/page.getSize()) + 1);
			pagination.setItems(rResponse.getBeans(YaoTrueSku.class));
			pagination.setStart(page.getStart());
			pagination.setTotalPages((int)pagination.getCount()/page.getSize() + (pagination.getCount()%page.getSize() == 0 ? 0 : 1));
			pagination.setSize(page.getSize());
			return pagination;
		} catch (SolrServerException e) {
			e.printStackTrace();;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.solr.SolrManager#refreshBySkuId(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public void refreshBySkuId(String skuId) {
		Sku sku = skuDao.getBySkuId(skuId);
		try {
			YaoTrueSku yaoTrueSku = new YaoTrueSku();
			BeanUtils.copyProperties(yaoTrueSku, sku);
			solrServer.addBean(yaoTrueSku);
			solrServer.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.solr.SolrManager#deleteAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public void deleteAll() {
		try {
			solrServer.deleteByQuery("*:*");
			solrServer.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.solr.SolrManager#deleteBySkuId(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public void deleteBySkuId(String skuId) {
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("skuId:"+skuId);
		
		try {
			QueryResponse queryResponse = solrServer.query(solrQuery);
			List<YaoTrueSku> yaoTrueSkus = queryResponse.getBeans(YaoTrueSku.class);
			if (null == yaoTrueSkus || yaoTrueSkus.size() == 0) {
				return;
			}
			YaoTrueSku yaoTrueSku = yaoTrueSkus.get(0);
			
			solrServer.deleteById(yaoTrueSku.getId().toString());
			solrServer.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
