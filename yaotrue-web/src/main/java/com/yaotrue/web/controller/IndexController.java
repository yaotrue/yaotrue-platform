/*
 * Copyright 1999-2017 YaoTrue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yaotrue.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.captcha.botdetect.web.servlet.SimpleCaptcha;
import com.yaotrue.web.command.BasicExample;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2018年4月26日 下午5:49:44
 */
@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/")
	public String index(Model model,HttpServletRequest request){
		logger.info("---------index----------");
		model.addAttribute("msg", "hello springmvc");
		return "index";
	}
	
	@RequestMapping("/testCaptch")
	public String validate(Model model,HttpServletRequest request,@ModelAttribute("basicExample") BasicExample basicExample){
	    
	    // validate the Captcha to check we're not dealing with a bot
	    SimpleCaptcha captcha = SimpleCaptcha.load(request, "basicExample");
	    boolean isHuman = captcha.validate(basicExample.getCaptchaCode());
	    if (isHuman) {
	      basicExample.setCaptchaCorrect("Correct code");
	      basicExample.setCaptchaIncorrect("");
	    } else {
	      basicExample.setCaptchaCorrect("");
	      basicExample.setCaptchaIncorrect("Incorrect code");
	    }
	    
	    basicExample.setCaptchaCode("");
	    model.addAttribute("basicExample", basicExample);
		return "index";
	}
}
