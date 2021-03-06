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
package com.yaotrue.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaotrue.event.EmailEvent;
import com.yaotrue.event.EventPublisher;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年6月16日 下午2:01:18
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private EventPublisher eventPublisher;
	
	@Value("#{meta['test.jasypt']}")
	private String testStr = "";

	@RequestMapping("/")
	public String index(Model model,HttpServletRequest request){
		model.addAttribute("msg", "hello springmvc");
		return "index";
	}
	
	@RequestMapping("/testEvent")
	public String testEvent(@RequestParam("code")String code,Model model){
		logger.info("---------testevent-----------");
		EmailEvent emailEvent = new EmailEvent(this, code);
		eventPublisher.publish(emailEvent);
		return "index";
	}
}
