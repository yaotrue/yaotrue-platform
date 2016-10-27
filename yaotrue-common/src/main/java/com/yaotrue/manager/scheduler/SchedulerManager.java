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

import java.util.Date;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年10月27日 上午9:12:54
 */
public interface SchedulerManager {

	/**
	 * 添加定时任务
	 * @param taskInstance  任务的实例
	 * @param taskMethod 调用任务的方法
	 * @param date 在什么时间执行
	 * @param jobName 任务名称(不能重复)，一般按照业务逻辑再加上一定的参数进行命名
	 */
	public void addTask(Object taskInstance,String taskMethod,Date date,String jobName)throws Exception;
	

	/**
	 * 添加定时任务
	 * @param taskInstance  任务的实例
	 * @param taskMethod 调用任务的方法
	 * @param timeExp 执行时间表达式
	 * @param jobName 任务名称(不能重复)，一般按照业务逻辑再加上一定的参数进行命名
	 */
	public void addTask(Object taskInstance,String taskMethod,String timeExp,String jobName)throws Exception;
	
	/**
	 * 删除定时任务
	 * @param jobName
	 */
	public void removeTask(String jobName)throws Exception;
	
	/**
	 * 定时清理任务
	 * @throws Exception
	 */
	public void timerClean()throws Exception;
}
