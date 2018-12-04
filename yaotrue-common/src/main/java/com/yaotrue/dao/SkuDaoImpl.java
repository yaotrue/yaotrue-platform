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
package com.yaotrue.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.EntityEntry;
import org.hibernate.engine.ForeignKeys;
import org.hibernate.engine.Status;
import org.hibernate.impl.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yaotrue.model.sku.Sku;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a> 2016年11月1日 下午2:56:03
 */
//@Repository
public class SkuDaoImpl implements SkuDao {

	private static final Logger logger = LoggerFactory.getLogger(SkuDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yaotrue.dao.SkuDao#saveSku(com.yaotrue.model.sku.Sku)
	 */
	@Override
	public Sku saveSku(Sku sku) {
		Session session = getSession();
		if (EntityStatus.TRANSIENT == getStatus(sku)) {
			session.persist(sku);
			return sku;
		} else {
			return (Sku) session.merge(sku);
		}
	}

	protected Session getSession() {
		// return SessionFactoryUtils.getSession(sessionFactory, true);
		return sessionFactory.getCurrentSession();
	}

	private EntityStatus getStatus(Object model) {
		SessionImpl simpl = (SessionImpl) getSession();
		EntityEntry entry = simpl.getPersistenceContext().getEntry(model);
		if (entry != null) {
			// Persistent Object
			logger.debug("current {} is one Entity with entry in PersistenceContext.", model);
			if (entry.getStatus() != Status.DELETED) {
				logger.debug("EntityStatus: {}", EntityStatus.PERSISTENT);
				return EntityStatus.PERSISTENT;
			} else {
				logger.debug("EntityStatus: {}", EntityStatus.REMOVED);
				return EntityStatus.REMOVED;
			}
		} else {
			// Detached or Transient Object
			logger.debug("current {} is one Entity without entry in PersistenceContext.", model);
			if (ForeignKeys.isTransient(null, model, null, simpl)) {
				logger.debug("EntityStatus: {}", EntityStatus.TRANSIENT);
				return EntityStatus.TRANSIENT;
			} else {
				logger.debug("EntityStatus: {}", EntityStatus.DETACHED);
				return EntityStatus.DETACHED;
			}
		}
	}

	protected static enum EntityStatus {
		TRANSIENT, PERSISTENT, DETACHED, REMOVED
	}

	/* (non-Javadoc)
	 * @see com.yaotrue.dao.SkuDao#findAllSku()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Sku> findAllSku() {
		return (ArrayList<Sku>)jdbcTemplate.query("select id,category_name AS categoryName,commission,income_rate AS incomeRate,online_time as onLineTime,platform_name AS platformName,price,sales_count AS salesCount,shop_name AS shopName,sku_detail_url AS skuDetailUrl,sku_id AS skuId,sku_img_url AS skuImgUrl,sku_name AS skuName,status,tg_url AS tgUrl,view_count AS viewCount from t_yt_sku order by id", new BeanPropertyRowMapper(Sku.class));
	}

	/* (non-Javadoc)
	 * @see com.yaotrue.dao.SkuDao#getBySkuId(java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Sku getBySkuId(String skuId) {
		List<Sku> skus = ((ArrayList<Sku>)jdbcTemplate.query("select id,category_name AS categoryName,commission,income_rate AS incomeRate,online_time as onLineTime,platform_name AS platformName,price,sales_count AS salesCount,shop_name AS shopName,sku_detail_url AS skuDetailUrl,sku_id AS skuId,sku_img_url AS skuImgUrl,sku_name AS skuName,status,tg_url AS tgUrl,view_count AS viewCount from t_yt_sku where sku_id=?", new Object[]{skuId}, new BeanPropertyRowMapper(Sku.class)));
		if(null == skus || 0 == skus.size()){
			return null;
		}
		return skus.get(0);
	}

}
