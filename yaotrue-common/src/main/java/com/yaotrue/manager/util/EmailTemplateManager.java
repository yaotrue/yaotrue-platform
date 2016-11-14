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

import java.util.List;
import java.util.Map;

import com.yaotrue.command.util.EmailAttachmentCommand;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年10月27日 下午3:14:24
 */
public interface EmailTemplateManager {

	/**
	 * 发送邮件
	 * @param receiverEmail 接收邮件人
	 * @param code 邮件模板编码
	 * @param dataMap 替换模板中数据
	 */
	public void sendEmail(String receiverEmail,String code,Map<String,Object> dataMap)throws Exception;
	
	/**
	 * 发送邮件
	 * @param receiverEmail 接收邮件人
	 * @param code 邮件模板编码
	 * @param dataMap 替换模板中数据
	 * @param attachmentList 表示为附件列表
	 */
	public void sendEmail(String[] receiverEmail,String code,Map<String,Object> dataMap,List<EmailAttachmentCommand> attachmentList)throws Exception;
}
