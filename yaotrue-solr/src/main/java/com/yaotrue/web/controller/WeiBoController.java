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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import weibo4j.Oauth;
import weibo4j.Timeline;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.Emotion;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年11月15日 上午10:42:12
 */
@Controller
@RequestMapping("/weibo")
public class WeiBoController {

	@RequestMapping("/toLogin.htm")
	public String toLogin(Model model,HttpServletRequest request) {
		String url="";
		try {
			Oauth oauth = new Oauth();
			url = oauth.authorize("code");
			request.getSession().setAttribute("sina_oauth", oauth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:" +url;
	}
	
	@RequestMapping("/callback.htm")
	public String callback(Model model,HttpServletRequest request,HttpServletResponse response){
		Oauth sinaOauth=(Oauth)request.getSession().getAttribute("sina_oauth");
		String code = request.getParameter("code");
		String uid=null;
		try {
			AccessToken accessToken = sinaOauth.getAccessTokenByCode(code);
			String access_token = accessToken.getAccessToken();
			uid = accessToken.getUid();
			Users um = new Users(access_token);
			User user = um.showUserById(uid);
			request.getSession().setAttribute("user", user);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
		return "redirect:/weibo/";
	}
	
	@RequestMapping("/")
	public String index(Model model,HttpServletRequest request) {
		return "weibo/index";
	}
	
	@RequestMapping("/showEmotion.htm")
	public String showEmotion(Model model,HttpServletRequest request) {
		String access_token = WeiboConfig.getValue("access_token");
		Timeline tm = new Timeline(access_token);
		try {
			List<Emotion> emotions =  tm.getEmotions();
			model.addAttribute("emotions", emotions);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return "weibo/emotion";
	}
}
