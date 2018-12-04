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
package com.yaotrue.feature.sitemap;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

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
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年7月4日 下午4:50:38
 */
public class MicrosoftRamCrawler extends RamCrawler {
	
	private static final Logger logger = LoggerFactory.getLogger(MicrosoftRamCrawler.class);
	
	private WebSitemapGenerator sitemapGenerator;
	
	private Set<String> containsUrl;
	
	public MicrosoftRamCrawler(String url,WebSitemapGenerator sitemapGenerator,Set<String> containsUrl) {
		logger.warn("------MicrosoftRamCrawler--------");
		this.sitemapGenerator = sitemapGenerator;
		this.containsUrl = containsUrl;
		CrawlDatum datum = new CrawlDatum(url);
		addSeed(datum);
	}

	/* (non-Javadoc)
	 * @see cn.edu.hfut.dmic.webcollector.fetcher.Visitor#visit(cn.edu.hfut.dmic.webcollector.model.Page, cn.edu.hfut.dmic.webcollector.model.CrawlDatums)
	 */
	@Override
	public void visit(Page page, CrawlDatums next) {
		String url = page.getUrl().indexOf("?") == -1 ? page.getUrl() : page.getUrl().substring(0, page.getUrl().indexOf("?"));
		logger.warn("---------------visit----------------url:{}",url);
		Elements elements = page.select("a");
		if (elements.isEmpty() && containsUrl.contains(url)) {
			return;
		}
		
		try {
			WebSitemapUrl sitemapUrl = new WebSitemapUrl.Options(url)
					.lastMod(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).priority(1.0).changeFreq(ChangeFreq.HOURLY).build();
			// this will configure the URL with lastmod=now, priority=1.0,
			// changefreq=hourly
			
			// You can add any number of urls here
			sitemapGenerator.addUrl(sitemapUrl);
			containsUrl.add(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<Element> iterator = elements.iterator();
		while (iterator.hasNext()) {
			Element ahref = iterator.next();
			String href = ahref.attr("href");
			href = href.indexOf("?") == -1 ? href : href.substring(0, href.indexOf("?"));
			if (StringUtil.isBlank(href) || !href.startsWith("https://www.microsoftstore.com.hk")
					|| containsUrl.contains(href) || href.startsWith("https://www.microsoftstore.com.hk/oauth")
					|| href.startsWith("https://www.microsoftstore.com.hk/account")
					|| href.startsWith("https://www.microsoftstore.com.hk/login")
					|| href.startsWith("https://www.microsoftstore.com.hk/shoppingcart")) {
				continue;
			}
			containsUrl.add(href);
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

			next.add(href);
		}
	}

}
