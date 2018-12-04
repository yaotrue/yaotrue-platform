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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaotrue.command.Page;
import com.yaotrue.command.web.ControllerJsonResponceCommand;
import com.yaotrue.manager.solr.SolrManager;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a> 2016年11月1日 下午4:10:41
 */
@Controller
public class SolrManagerController {

	private static final Logger logger = LoggerFactory.getLogger(SolrManagerController.class);

	@Autowired
	private SolrManager solrManager;

	@RequestMapping("/solrManager.htm")
	public String solrManager(Model model) {
		logger.debug("hello");
		model.addAttribute("msg", "hello springmvc");
		return "sku/solrManager";
	}

	@ResponseBody
	@RequestMapping(value = "/solrRefreshAll.json", method = RequestMethod.POST)
	public ControllerJsonResponceCommand solrRefreshAll(HttpServletRequest request, Model model) {
		solrManager.refreshSolr();
		return new ControllerJsonResponceCommand(true,"刷新成功");
	}
	
	@ResponseBody
	@RequestMapping(value = "/solrDeleteAll.json", method = RequestMethod.POST)
	public ControllerJsonResponceCommand solrDeleteAll(HttpServletRequest request, Model model) {
		solrManager.deleteAll();
		return new ControllerJsonResponceCommand(true,"情况成功");
	}
	
	@ResponseBody
	@RequestMapping(value = "/solrRefreshBySkuId.json", method = RequestMethod.POST)
	public ControllerJsonResponceCommand solrRefreshBySkuId(HttpServletRequest request, Model model,@RequestParam("skuId")String skuId) {
		solrManager.refreshBySkuId(skuId);
		return new ControllerJsonResponceCommand(true,"刷新成功");
	}
	
	@ResponseBody
	@RequestMapping(value = "/solrDeleteBySkuId.json", method = RequestMethod.POST)
	public ControllerJsonResponceCommand solrDeleteBySkuId(HttpServletRequest request, Model model,@RequestParam("skuId")String skuId) {
		solrManager.deleteBySkuId(skuId);
		return new ControllerJsonResponceCommand(true,"删除成功");
	}

	@RequestMapping("/solrView.htm")
	public String solrView(Model model, @RequestParam(value = "pageNo", required = false) Integer pageNo) {
		model.addAttribute("pagination",
				solrManager.findSkuByParams(new Page(null == pageNo || pageNo <= 0 ? 1 : pageNo, 50), null));
		return "sku/solrView";
	}
}
