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
package com.yaotrue.framework.scheduler;

import java.util.Date;

import org.junit.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年5月24日 下午5:05:54
 */
public class QuartzTest {
	
	private static final Logger logger = LoggerFactory.getLogger(QuartzTest.class);
	
	@Test
	public void testQuartz() throws SchedulerException{
		logger.info("------- Initializing ----------------------");  
		  
	    // 1、工厂模式 构建Scheduler的Factory，其中STD为Quartz默认的Factory，开发者亦可自行实现自己的Factory;Job、Trigger等组件  
	    SchedulerFactory sf = new StdSchedulerFactory();  
	    // 2、通过SchedulerFactory获得Scheduler对象  
	    Scheduler sched = sf.getScheduler();  
	  
	    logger.info("------- Initialization Complete -----------");  
	  
	    // 3、org.quartz.DateBuilder.evenMinuteDate <下一分钟>  -- 通过DateBuilder构建Date  
	    Date runTime = DateBuilder.evenMinuteDate(new Date());  
	  
	    logger.info("------- Scheduling Job  -------------------");  
	  
	    // 4、org.quartz.JobBuilder.newJob --通过JobBuilder构建Job  
	    JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();  
	  
	    // 5、通过TriggerBuilder进行构建  
	    Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1" , "group1").startAt(runTime ).build();
	  
	    // 6、工厂模式，组装各个组件<JOB，Trigger>  
	    sched.scheduleJob(job, trigger);  
	     
	    // [group1.job1] will run at:  
	    logger.info(job.getKey() + " will run at: " + runTime);  
	  
	    // 7、start  
	    sched.start();  
	  
	    logger.info("------- Started Scheduler -----------------");  
	  
	    logger.info("------- Waiting 65 seconds... -------------");  
	    try {  
	      // wait 65 seconds to show job  
	      Thread.sleep(65L * 1000L);  
	      // executing...  
	    } catch (Exception e) {  
	      //  
	    }  
	  
	    // shut down the scheduler  
	    logger.info("------- Shutting Down ---------------------");  
	    // 8、通过Scheduler销毁内置的Trigger和Job  
	    sched.shutdown(true);  
	    logger.info("------- Shutdown Complete -----------------");  
	}
	
	@Test
	public void springQuartzTest() throws SchedulerException{
		SchedulerFactory sf = new StdSchedulerFactory();  
	    // 2、通过SchedulerFactory获得Scheduler对象  
	    Scheduler sched = sf.getScheduler();
	    
	    JobDetail jobDetail= JobBuilder.newJob(HelloJob.class).withIdentity("job1", Scheduler.DEFAULT_GROUP).build();
	    
	    // 触发器  
        TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
        // 触发器名,触发器组  
        triggerBuilder.withIdentity("job1", Scheduler.DEFAULT_GROUP);
        triggerBuilder.startNow();
        // 触发器时间设定  
        triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"));
        // 创建Trigger对象
        CronTrigger trigger = (CronTrigger)triggerBuilder.build();

        // 调度容器设置JobDetail和Trigger
        sched.scheduleJob(jobDetail, trigger);  

        // 启动  
        if (!sched.isShutdown()) {  
            sched.start();  
        }
        
        try {
			Thread.sleep(new Long(1000 * 60));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
