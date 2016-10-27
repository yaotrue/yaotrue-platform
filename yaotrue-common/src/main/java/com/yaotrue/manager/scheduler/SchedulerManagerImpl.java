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
package com.yaotrue.manager.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年10月27日 上午9:15:19
 */
@Service("schedulerManager")
public class SchedulerManagerImpl implements SchedulerManager {
	
	@Autowired(required=false)
	private SchedulerFactoryBean scheduler;

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.scheduler.SchedulerManager#addTask(java.lang.Object, java.lang.String, java.util.Date, java.lang.String)
	 */
	@Override
	public void addTask(Object taskInstance, String taskMethod, Date date, String jobName) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("s m H d M ? yyyy");
		String strDate=sdf.format(date);
		addTask(taskInstance,taskMethod,strDate,jobName);
	}

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.scheduler.SchedulerManager#addTask(java.lang.Object, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void addTask(Object taskInstance, String taskMethod, String timeExp, String jobName) throws Exception {
		MethodInvokingJobDetailFactoryBean mifb=new MethodInvokingJobDetailFactoryBean();
		
		mifb.setTargetObject(taskInstance);
		mifb.setTargetMethod(taskMethod);
		mifb.setConcurrent(false);
		mifb.setName(jobName);
		mifb.afterPropertiesSet();
		
	    // 触发器  
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        // 触发器名,触发器组  
        triggerBuilder.withIdentity(jobName, Scheduler.DEFAULT_GROUP);
        triggerBuilder.startNow();
        // 触发器时间设定  
        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(timeExp));
        // 创建Trigger对象
        CronTrigger trigger = (CronTrigger)triggerBuilder.build();

        // 调度容器设置JobDetail和Trigger
		scheduler.getScheduler().scheduleJob(mifb.getObject(), trigger);
	}

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.scheduler.SchedulerManager#removeTask(java.lang.String)
	 */
	@Override
	public void removeTask(String jobName) throws Exception {
		JobKey jobKey = new JobKey(jobName, Scheduler.DEFAULT_GROUP);
		scheduler.getScheduler().deleteJob(jobKey);
	}

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.scheduler.SchedulerManager#timerClean()
	 */
	@Override
	public void timerClean() throws Exception {
		GroupMatcher<JobKey> groupMatcher = GroupMatcher.jobGroupEquals(Scheduler.DEFAULT_GROUP);
		Set<JobKey> jobs = scheduler.getScheduler().getJobKeys(groupMatcher);
		
		for (JobKey jobKey : jobs) {
			scheduler.getScheduler().deleteJob(jobKey);
		}
	}

}
