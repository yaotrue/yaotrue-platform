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
package com.yaotrue.model.system;

import com.yaotrue.model.BaseModel;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a> 2016年10月27日
 *         下午4:17:01
 */
public class EmailTemplate extends BaseModel {

	/**
	 * <code>{@value}</code>
	 */
	private static final long serialVersionUID = 3086161093142200179L;

	/**
	 * 模板编码
	 */
	private String code;
	/**
	 * 模板名称
	 */
	private String name;

	/**
	 * 模板描述
	 */
	private String description;

	/**
	 * type:1为html type:2为text
	 */
	private Integer type;

	/**
	 * 主题
	 */
	private String subject;

	/**
	 * 消息正文
	 */
	private String body;

	/**
	 * 发件人别名
	 */
	private String senderAlias;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the senderAlias
	 */
	public String getSenderAlias() {
		return senderAlias;
	}

	/**
	 * @param senderAlias
	 *            the senderAlias to set
	 */
	public void setSenderAlias(String senderAlias) {
		this.senderAlias = senderAlias;
	}

}
