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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaotrue.command.util.EmailAttachmentCommand;
import com.yaotrue.manager.util.EmailTemplateManager;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a> 2016年10月27日
 *         上午11:26:12
 */
@Service("tmall20161111TgManager")
public class Tmall20161111TgManagerImpl implements Tmall20161111TgManager {

	private static final Logger logger = LoggerFactory.getLogger(Tmall20161111TgManagerImpl.class);
	
	@Autowired
	private EmailTemplateManager emailTemplateManager;

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.scheduler.Tmall20161111TgManager#sendEmail()
	 */
	@Override
	public void sendEmail() {
		logger.info("send email....");
		List<EmailAttachmentCommand> emailAttachmentCommands = new ArrayList<EmailAttachmentCommand>();
		EmailAttachmentCommand emailAttachmentCommand = new EmailAttachmentCommand();
		emailAttachmentCommand.setName("2015天猫双11预售爆款抢先定.xls");
		emailAttachmentCommand.setFilePath("E:/Me/life/yaotrue/2015天猫双11预售爆款抢先定.xls");
		emailAttachmentCommands.add(emailAttachmentCommand);
		
		EmailAttachmentCommand emailAttachmentCommand2 = new EmailAttachmentCommand();
		emailAttachmentCommand2.setName("2016双11聚划算爆款清单.xls");
		emailAttachmentCommand2.setFilePath("E:/Me/life/yaotrue/2016双11聚划算爆款清单.xls");
		emailAttachmentCommands.add(emailAttachmentCommand2);
		
		EmailAttachmentCommand emailAttachmentCommand3 = new EmailAttachmentCommand();
		emailAttachmentCommand3.setName("2016双11淘宝爆款清单.xls");
		emailAttachmentCommand3.setFilePath("E:/Me/life/yaotrue/2016双11淘宝爆款清单.xls");
		emailAttachmentCommands.add(emailAttachmentCommand3);
		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("receiver", "1019894597@qq.com");
		String[] emailArray = new String[]{"1019894597@qq.com","695552241@qq.com","yaozhen421515@163.com","yaozhen421524@163.com","dashabiyz@sina.com"};
		try {
			emailTemplateManager.sendEmail(emailArray, "hehe", params,emailAttachmentCommands);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
