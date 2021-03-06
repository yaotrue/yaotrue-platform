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

import java.io.File;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a> 2016年5月27日
 *         上午10:43:57
 */
public class SitemapTest {

	@Test
	public void testSitemap() throws MalformedURLException {
		WebSitemapGenerator sitemapGenerator = WebSitemapGenerator
				.builder("https://www.baidu.com", new File("E:/YaoTrue")).gzip(true).build();

		WebSitemapUrl sitemapUrl = new WebSitemapUrl.Options("https://www.baidu.com/cache/sethelp/help.html")
				.lastMod(new Date()).priority(1.0).changeFreq(ChangeFreq.HOURLY).build();
		// this will configure the URL with lastmod=now, priority=1.0,
		// changefreq=hourly

		// You can add any number of urls here
		sitemapGenerator.addUrl(sitemapUrl);
		sitemapGenerator.addUrl("https://www.baidu.com/duty/");
		sitemapGenerator.write();
	}
	
	@Test
	public void testSitemap2() throws Exception{
		File file = new File("E:/YaoTrue");
		
		WebSitemapGenerator sitemapGenerator = WebSitemapGenerator
				.builder("https://www.microsoftstore.com.hk", file).build();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		DemoBingCrawler crawler = new DemoBingCrawler("https://www.microsoftstore.com.hk",sitemapGenerator,map);
		crawler.setThreads(50);
		crawler.start(4);
		
		sitemapGenerator.write();
	}
	
	public static void main(String[] args) throws Exception {
		File file = new File("E:/YaoTrue/temp3");
		
		WebSitemapGenerator sitemapGenerator = WebSitemapGenerator
				.builder("https://www.microsoftstore.com.hk", file).build();
		Set<String> strings = new HashSet<String>();
		
//		DemoBingCrawler crawler = new DemoBingCrawler("https://www.microsoftstore.com.hk",sitemapGenerator,map);
		MicrosoftRamCrawler crawler = new MicrosoftRamCrawler("https://www.microsoftstore.com.hk", sitemapGenerator, strings);
		crawler.setThreads(50);
		crawler.start(4);
		
		sitemapGenerator.write();
	}
}
