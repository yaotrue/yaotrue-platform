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
package com.yaotrue.manager.util;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.yaotrue.command.util.EmailAttachmentCommand;
import com.yaotrue.command.util.EmailCommand;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年10月27日 下午1:28:56
 */
@Service
public class MailServiceImpl implements MailService {
	
	private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
	
	@Resource
	JavaMailSender javaMailSender;// 注入Spring封装的javamail，Spring的xml中已让框架装配
	@Resource
	TaskExecutor taskExecutor;// 注入Spring封装的异步执行器

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.util.MailSerice#sendMail(com.yaotrue.command.util.EmailCommand)
	 */
	@Override
	public void sendMail(EmailCommand email) {
		sendMailTask(email);
	}
	
	private void sendMailTask(final EmailCommand email){
		taskExecutor.execute(new Runnable() {
			public void run() {
				try {
					MimeMessage mime = javaMailSender.createMimeMessage();
					if(null != email.getAddressArray()){
						@SuppressWarnings("static-access")
						InternetAddress[] iaToList = new InternetAddress().parse(getMailList(email.getAddressArray())); 
						mime.setRecipients(RecipientType.BCC, iaToList); // 收件人 
					}
					MimeMessageHelper helper = new MimeMessageHelper(mime,
							true, "utf-8");
					if(null == email.getSenderAlias() || email.getSenderAlias().trim().equals(""))
						helper.setFrom(email.getFrom());// 发件人
					else
						helper.setFrom(email.getFrom(), email.getSenderAlias());// 发件人 加上别名
					
					if(null != email.getAddress()){
						helper.setTo(email.getAddress());// 收件人
					}
					
					helper.setSubject(email.getSubject());// 邮件主题
					helper.setText(email.getContent(), true);// true表示设定html格式
					if(email.getAttachmentList()!=null){
						for(EmailAttachmentCommand eac:email.getAttachmentList()){
							helper.addAttachment(eac.getName(), new FileSystemResource(eac.getFilePath()));
						}
					}
					
					javaMailSender.send(mime);
				} catch (Exception e) {
				    logger.error(e.getMessage(), e);
				}
			}
		});
	}
	
	private String getMailList(String[] mailArray) {
		StringBuffer toList = new StringBuffer();
		int length = mailArray.length;
		if (mailArray != null && length < 2) {
			toList.append(mailArray[0]);
		} else {
			for (int i = 0; i < length; i++) {
				toList.append(mailArray[i]);
				if (i != (length - 1)) {
					toList.append(",");
				}

			}
		}
		return toList.toString();

	}

}
