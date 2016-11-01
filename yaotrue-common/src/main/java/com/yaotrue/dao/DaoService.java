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
package com.yaotrue.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;

import com.yaotrue.command.Pagination;
import com.yaotrue.command.Sort;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年11月1日 下午2:29:49
 */
public interface DaoService {

	<T> T getByPrimaryKey(Class<T> clazz, Serializable pk);
	
	<T> T save(T model);
	<T> void delete(T model);
	<T> void deleteByPrimaryKey(Class<T> clazz,Serializable pk);
	
	<T> T findOneByNamedQuery(String queryName, Map<String,Object> params, Sort[] sorts);
	<T> T findOneByQuery(String queryString, Map<String,Object> params, Sort[] sorts);
	
	/**
	 * Similiar with findOneByQuery, the difference is that the params can contain other definition do not used by query 
	 * @param <T>
	 * @param queryString
	 * @param params
	 * @return
	 */
	<T> T findOneByQueryEx(String queryString, Map<String,Object> params, Sort[] sorts);	
	
	<T> List<T> findByNamedQuery(String queryName, Map<String,Object> params);
	<T> List<T> findByNamedQuery(String queryName, Map<String,Object> params, int start, int pageSize);
	<T> Pagination<T> findByNamedQuery(String queryName, Map<String,Object> params, int start, int pageSize, boolean withGroupby);
	<T> List<T> findByNamedQuery(String queryName, Map<String,Object> params, Sort[] sorts);
	<T> List<T> findByNamedQuery(String queryName, Map<String,Object> params, Sort[] sorts, int start, int pageSize);
	<T> Pagination<T> findByNamedQuery(String queryName, Map<String,Object> params, Sort[] sorts, int start, int pageSize, boolean withGroupby);
	
	<T> List<T> findByQuery(String queryString, Map<String,Object> params);
	<T> List<T> findByQuery(String queryString, Map<String,Object> params, int start, int pageSize);
	<T> Pagination<T> findByQuery(String queryString, Map<String,Object> params, int start, int pageSize, boolean withGroupby);
	<T> List<T> findByQuery(String queryString, Map<String,Object> params, Sort[] sorts);
	<T> List<T> findByQuery(String queryString, Map<String,Object> params, Sort[] sorts, int start, int pageSize);
	<T> Pagination<T> findByQuery(String queryString, Map<String,Object> params, Sort[] sorts, int start, int pageSize, boolean withGroupby);
	
	/**
	 * Similiar with findByQuery, the difference is that the params can contain other definition do not used by query 
	 * @param <T>
	 * @param queryString
	 * @param params
	 * @param sorts
	 * @param start
	 * @param pageSize
	 * @return
	 */
	<T> List<T> findByQueryEx(String queryString, Map<String,Object> params, Sort[] sorts, int start, int pageSize);
	<T> Pagination<T> findByQueryEx(String queryString, Map<String,Object> params, Sort[] sorts, int start, int pageSize, boolean withGroupby);
	
	int batchUpdateByNamedQuery(String queryName, Map<String,Object> params);
	int batchUpdateByQuery(String queryString, Map<String,Object> params);
		
	<T> List<T> findByNativeQuery(String queryString, Object[] params, RowMapper<T> rowMapper);
	<T> List<T> findByNativeQuery(String queryString, Object[] params, int start, int pageSize, RowMapper<T> rowMapper);
	<T> Pagination<T> findByNativeQuery(String queryString, Object[] params, int start, int pageSize, boolean withGroupby, RowMapper<T> rowMapper);
	<T> List<T> findByNativeQuery(String queryString, Object[] params, Sort[] sorts, RowMapper<T> rowMapper);
	<T> List<T> findByNativeQuery(String queryString, Object[] params, Sort[] sorts, int start, int pageSize, RowMapper<T> rowMapper);
	<T> Pagination<T> findByNativeQuery(String queryString, Object[] params, Sort[] sorts, int start, int pageSize, boolean withGroupby, RowMapper<T> rowMapper);
	
	<T> T findOneByNativeQuery(String queryString, Object[] params, RowMapper<T> rowMapper, Sort[] sorts);
		
	int batchUpdateByNativeQuery(String queryString, Object[] params, Class<?>[] types);
	
	void executeDDL(String queryString);
	
	Map<String,Object> executeSP(String spName);
	Map<String,Object> executeSp(String spName, SqlParameter[] sqlParameters, Map<String,Object> params);
	
	void flush();
	<T> void evict(T model);
	
}
