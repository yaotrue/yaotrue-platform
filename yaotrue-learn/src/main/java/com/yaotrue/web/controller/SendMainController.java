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
package com.yaotrue.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaotrue.command.util.EmailAttachmentCommand;
import com.yaotrue.manager.util.EmailTemplateManager;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年10月27日 下午3:13:25
 */
@Controller
public class SendMainController {

	@Autowired
	private EmailTemplateManager emailTemplateManager;
	
	@RequestMapping("/sendMail")
	@ResponseBody
	public void sendMail(@RequestParam("email")String email,Model model,HttpServletResponse response){
		try {
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("receiver", "1019894597@qq.com");
			emailTemplateManager.sendEmail(email, "hehe", params);
			response.getWriter().write("ok");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().write("error");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@RequestMapping("/sendMailAndAttatch")
	@ResponseBody
	public void sendMailAndAttatch(@RequestParam("email")String email,Model model,HttpServletResponse response){
		try {
			List<EmailAttachmentCommand> emailAttachmentCommands = new ArrayList<EmailAttachmentCommand>();
			EmailAttachmentCommand emailAttachmentCommand = new EmailAttachmentCommand();
			emailAttachmentCommand.setName("测试附件.jpg");
			emailAttachmentCommand.setFilePath("E:/Me/life/photoshop/resources/image/scenery/stock-photo-179331717.jpg");
			emailAttachmentCommands.add(emailAttachmentCommand);
			
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("receiver", "1019894597@qq.com");
			emailTemplateManager.sendEmail(new String[]{email}, "hehe", params,emailAttachmentCommands);
			response.getWriter().write("ok");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().write("error");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
