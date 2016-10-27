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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a> 2016年10月27日
 *         上午11:26:12
 */
@Service("tmall20161111TgManager")
public class Tmall20161111TgManagerImpl implements Tmall20161111TgManager {

	private static final Logger logger = LoggerFactory.getLogger(Tmall20161111TgManagerImpl.class);

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.scheduler.Tmall20161111TgManager#sendEmail()
	 */
	@Override
	public void sendEmail() {
		logger.info("send email....");
	}

}