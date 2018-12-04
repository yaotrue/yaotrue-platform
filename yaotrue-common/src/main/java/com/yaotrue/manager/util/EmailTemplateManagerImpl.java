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
package com.yaotrue.manager.util;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaotrue.command.util.EmailAttachmentCommand;
import com.yaotrue.command.util.EmailCommand;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a> 2016年10月27日
 *         下午3:14:59
 */
@Service("emailTemplateManager")
public class EmailTemplateManagerImpl implements EmailTemplateManager {

	@Autowired
	private MailService mailService;

	@Autowired
	private VelocityManager velocityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yaotrue.manager.util.EmailTemplateManager#sendEmail(java.lang.String,
	 * java.lang.String, java.util.Map)
	 */
	@Override
	public void sendEmail(String receiverEmail, String code, Map<String, Object> dataMap) throws Exception {
		sendEmail(new String[]{receiverEmail}, code, dataMap, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yaotrue.manager.util.EmailTemplateManager#sendEmail(java.lang.String,
	 * java.lang.String, java.util.Map, java.util.List)
	 */
	@Override
	public void sendEmail(String[] receiverEmail, String code, Map<String, Object> dataMap,
			List<EmailAttachmentCommand> attachmentList) throws Exception {

		EmailCommand ec = constructMail(receiverEmail, dataMap, attachmentList);
		mailService.sendMail(ec);
	}

	private EmailCommand constructMail(String[] receiverEmail, Map<String, Object> params,
			List<EmailAttachmentCommand> attachmentList) throws MessagingException, UnsupportedEncodingException {
		String content = velocityManager.parseVMTemplate("velocity/20161111.vm", params);
		String subject = "2016天猫双十一大狂欢";

		EmailCommand ec = new EmailCommand();
		ec.setAddressArray(receiverEmail);
		ec.setFrom("yaotrue@163.com");
		ec.setSubject(subject);
		ec.setContent(content);
		ec.setAttachmentList(attachmentList);
		ec.setSenderAlias("yaotrue");
		ec.setIdentifier("code");
		return ec;

	}

}
