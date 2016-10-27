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
package com.yaotrue.command.util;

import java.util.List;

import com.yaotrue.command.Command;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年10月27日 下午1:26:15
 */
public class EmailCommand extends Command {

	/**
	 * <code>{@value}</code>
	 */
	private static final long serialVersionUID = 3570520879852078834L;
	
	/** 发件人 **/
	private String from;
	
	/** 收件人 **/
	private String address;

	/** 邮件主题 **/
	private String subject;

	/** 邮件内容 **/
	private String content;
	
	/**
	 * 发件人别名
	 */
	private String senderAlias;
	
	/**
	 * 附件列表
	 */
	private List<EmailAttachmentCommand> attachmentList=null;
	
	/** 同一种类型邮件的标识，比如同一个邮件模板发出的邮件，可使用模板的编码作为标识 */
	private String identifier;

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the senderAlias
	 */
	public String getSenderAlias() {
		return senderAlias;
	}

	/**
	 * @param senderAlias the senderAlias to set
	 */
	public void setSenderAlias(String senderAlias) {
		this.senderAlias = senderAlias;
	}

	/**
	 * @return the attachmentList
	 */
	public List<EmailAttachmentCommand> getAttachmentList() {
		return attachmentList;
	}

	/**
	 * @param attachmentList the attachmentList to set
	 */
	public void setAttachmentList(List<EmailAttachmentCommand> attachmentList) {
		this.attachmentList = attachmentList;
	}

	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

}
