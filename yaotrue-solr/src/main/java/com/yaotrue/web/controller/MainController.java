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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaotrue.command.Page;
import com.yaotrue.command.web.ControllerJsonResponceCommand;
import com.yaotrue.manager.sku.SkuManager;
import com.yaotrue.manager.solr.SolrManager;
import com.yaotrue.util.MultipartFileUtils;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a> 2016年11月1日 下午1:21:53
 */
@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private SkuManager skuManager;
	
	@Autowired
	private SolrManager solrManager;

	@RequestMapping("/")
	public String index(Model model) {
		logger.debug("hello");
		model.addAttribute("msg", "hello springmvc");
		return "index";
	}
	
	@RequestMapping("/navigation.htm")
	public String navigation(Model model) {
		return "navigation";
	}
	
	@RequestMapping("/category.htm")
	public String category(Model model,@RequestParam(value="pageNo",defaultValue="1")Integer pageNo) {
		model.addAttribute("pagination", solrManager.findSkuByParams(new Page(pageNo,30), null));
		return "category";
	}
	
	@RequestMapping("/search.htm")
	public String search(Model model,@RequestParam(value="keyword",required=false)String keyword,@RequestParam(value="pageNo",defaultValue="1")Integer pageNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keyword", keyword);
		model.addAttribute("pagination", solrManager.findSkuByParams(new Page(pageNo,30), params));
		model.addAttribute("keyword", keyword);
		return "search";
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
