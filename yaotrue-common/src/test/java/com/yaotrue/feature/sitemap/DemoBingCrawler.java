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
package com.yaotrue.feature.sitemap;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.ram.RamCrawler;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a> 2016年5月27日
 *         上午11:35:40
 */
public class DemoBingCrawler extends RamCrawler {

	private static final Logger logger = LoggerFactory.getLogger(DemoBingCrawler.class);
	
	private WebSitemapGenerator sitemapGenerator;
	
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public DemoBingCrawler(String url,WebSitemapGenerator sitemapGenerator,Map<String, Integer> map) throws Exception {
		this.sitemapGenerator = sitemapGenerator;
		this.map = map;
		CrawlDatum datum = new CrawlDatum(url);
		addSeed(datum);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.hfut.dmic.webcollector.fetcher.Visitor#visit(cn.edu.hfut.dmic.
	 * webcollector.model.Page, cn.edu.hfut.dmic.webcollector.model.CrawlDatums)
	 */
	public void visit(Page page, CrawlDatums next) {
		if (map.containsKey(page.getUrl())) {
			return;
		}
		try {
			WebSitemapUrl sitemapUrl = new WebSitemapUrl.Options(page.getUrl())
					.lastMod(new Date()).priority(1.0).changeFreq(ChangeFreq.HOURLY).build();
			// this will configure the URL with lastmod=now, priority=1.0,
			// changefreq=hourly
			
			// You can add any number of urls here
			sitemapGenerator.addUrl(sitemapUrl);
			map.put(page.getUrl(), null);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Elements elements = page.select("a");
		if (elements.isEmpty()) {
			return;
		}
		Iterator<Element> iterator = elements.iterator();
		while (iterator.hasNext()) {
			Element ahref = iterator.next();
			String href = ahref.attr("href");
			if (StringUtil.isBlank(href) || !href.startsWith("https://www.microsoftstore.com.hk") || map.containsKey(href)) {
				continue;
			}
			map.put(href, null);
			try {
				WebSitemapUrl sitemapUrl = new WebSitemapUrl.Options(href)
						.lastMod(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).priority(1.0).changeFreq(ChangeFreq.DAILY).build();
				// this will configure the URL with lastmod=now, priority=1.0,
				// changefreq=hourly
				
				// You can add any number of urls here
				sitemapGenerator.addUrl(sitemapUrl);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

			logger.warn("href:{}",href);
			next.add(href);
		}
//		logger.info("page:{},className:{}", page.getHtml(), next.getClass().getName());
	}
	
}
