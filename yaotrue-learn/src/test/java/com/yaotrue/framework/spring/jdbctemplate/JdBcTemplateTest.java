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
package com.yaotrue.framework.spring.jdbctemplate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSON;
import com.yaotrue.BaseTest;
import com.yaotrue.model.system.SchedulerTask;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年11月1日 上午10:40:55
 */
public class JdBcTemplateTest extends BaseTest {
	
	private static final Logger logger = LoggerFactory.getLogger(JdbcTemplate.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testQuery(){
		List<SchedulerTask> schedulerTasks = (ArrayList<SchedulerTask>)jdbcTemplate.query("select * from t_yt_scheduler_task order by id desc", new BeanPropertyRowMapper(SchedulerTask.class));
		for (SchedulerTask schedulerTask : schedulerTasks) {
			logger.info("jdbcTemplate select db result:{}",JSON.toJSONString(schedulerTask));
		}
	}
}
