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

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yaotrue.model.system.SchedulerTask;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年10月27日 上午11:23:41
 */
@Service("sdkSchedulerTaskManager")
public class SdkSchedulerTaskManagerImpl implements SdkSchedulerTaskManager {
	
	/* (non-Javadoc)
	 * @see com.yaotrue.manager.scheduler.SdkSchedulerTaskManager#findAllEffectSchedulerTaskList()
	 */
	@Override
	public List<SchedulerTask> findAllEffectSchedulerTaskList() {
		List<SchedulerTask> schedulerTasks = new ArrayList<SchedulerTask>();
		for (int i = 1;i<=1;i++) {
			SchedulerTask schedulerTask = new SchedulerTask();
			schedulerTask.setBeanName("tmall20161111TgManager");
			schedulerTask.setCode("job"+i);
			schedulerTask.setMethodName("sendEmail");
			schedulerTask.setTimeExp("0 0/10 * * * ?");
			schedulerTasks.add(schedulerTask);
		}
		return schedulerTasks;
	}

}
