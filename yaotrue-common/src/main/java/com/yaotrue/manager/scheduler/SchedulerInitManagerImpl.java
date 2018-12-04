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
package com.yaotrue.manager.scheduler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.yaotrue.model.system.SchedulerTask;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年10月27日 上午9:11:47
 */
@Service("schedulerInitManager")
public class SchedulerInitManagerImpl implements SchedulerInitManager {
	
	private static final Logger logger = LoggerFactory.getLogger(SchedulerInitManagerImpl.class);
	
	@Autowired
	private SchedulerManager schedulerManager;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private SdkSchedulerTaskManager sdkSchedulerTaskManager;

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.SchedulerInitManager#init()
	 */
	@Override
	public void init() {
		List<SchedulerTask> schedulerTasks = sdkSchedulerTaskManager.findAllEffectSchedulerTaskList();
		
		for (SchedulerTask schedulerTask : schedulerTasks) {
			Object taskInstance=applicationContext.getBean(schedulerTask.getBeanName());
			
			try {
				schedulerManager.addTask(taskInstance, schedulerTask.getMethodName(), schedulerTask.getTimeExp(), schedulerTask.getCode());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//
				logger.error("scheduler init task error");
			}
		}
	}

}
