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

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yaotrue.BaseTest;
import com.yaotrue.command.util.EmailCommand;
import com.yaotrue.manager.util.EmailTemplateManager;
import com.yaotrue.manager.util.MailService;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年10月27日 下午5:11:46
 */
public class SendMainTest extends BaseTest {

	@Autowired
	private EmailTemplateManager emailTemplateManager;
	
	@Autowired
	private MailService mailService;

	@Test
	public void testSendMail(){
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("receiver", "");
		try {
			emailTemplateManager.sendEmail("", "hehe", params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSendMail2(){
		EmailCommand emailCommand = new EmailCommand();
		emailCommand.setSenderAlias("");
		emailCommand.setFrom("");
		emailCommand.setAddress("");
		emailCommand.setSubject("");
		emailCommand.setContent("");
		
		mailService.sendMail(emailCommand);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
