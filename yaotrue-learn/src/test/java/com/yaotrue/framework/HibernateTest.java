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
package com.yaotrue.framework;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.yaotrue.BaseTest;
import com.yaotrue.model.system.SchedulerTask;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年11月1日 上午8:54:35
 */
public class HibernateTest extends BaseTest {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void testHibernate(){
		SchedulerTask schedulerTask = new SchedulerTask();
		sessionFactory.getCurrentSession();
		schedulerTask.setBeanName("beanName");
		schedulerTask.setCode("code");
		schedulerTask.setDescription("描述");
		schedulerTask.setLifecycle(1);
		schedulerTask.setMethodName("methodName");
		schedulerTask.setTimeExp("timeExp");
		hibernateTemplate.save(schedulerTask);
	}
}
