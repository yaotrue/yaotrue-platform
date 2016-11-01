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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaotrue.command.web.ControllerJsonResponceCommand;
import com.yaotrue.manager.sku.SkuManager;
import com.yaotrue.util.MultipartFileUtils;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a> 2016年11月1日 下午1:21:53
 */
@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private SkuManager skuManager;

	@RequestMapping("/")
	public String index(Model model) {
		logger.debug("hello");
		model.addAttribute("msg", "hello springmvc");
		return "index";
	}
	
	@RequestMapping("/skuUpload.htm")
	public String skuUpload(Model model) {
		return "sku/skuUpload";
	}

	/**
	 * 上传 商品基本信息 excel
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/skuUpload.json", method = RequestMethod.POST)
	public void skuUpload(HttpServletRequest request, Model model) {

		model.addAttribute("fileName", MultipartFileUtils.getFirstFileName(request));

		try {
			// 保存 备份 文件 至 备份文件夹
			File file = MultipartFileUtils.saveFile(request, "E:\\Me\\test\\", new SimpleDateFormat("yyyy-MM-dd_HHmmssSSS").format(new Date())+"-sku.xls");
			ControllerJsonResponceCommand jsonResponceCommand = skuManager.saveSkuByFile(file);
			model.addAttribute("responce", jsonResponceCommand);
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
		}
	}
}
