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

import com.yaotrue.model.system.SchedulerTask;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年10月27日 上午11:21:39
 */
public interface SdkSchedulerTaskManager {

	/**
	 * 获取有效的SchedulerTask列表
	 * lifecycle =1
	 * @param ids
	 * @return
	 */
	List<SchedulerTask> findAllEffectSchedulerTaskList();
}
