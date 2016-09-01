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
package com.yaotrue.framework.httpclient;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年6月23日 下午3:58:19
 */
public class HttpClientTest {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpClientTest.class);

	@Test
	public void testHttpClient(){
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		
		HttpGet httpGet = new HttpGet("https://www.microsoftstore.com.hk");
		
		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = closeableHttpClient.execute(httpGet);
			
			logger.info("get baidu response value:{}",httpResponse.getStatusLine().toString());
			
			Header[] headers = httpResponse.getAllHeaders();
			
			for (Header header : headers) {
				logger.info("header name:{},header value:{}",header.getName(),header.getValue());
			}
			
			HttpEntity httpEntity = httpResponse.getEntity();
			
			logger.info("entity tostring:{}",EntityUtils.toString(httpEntity, "UTF-8"));
			
			EntityUtils.consume(httpEntity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (null != httpResponse) {
					httpResponse.close();
				}
				closeableHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testPostMethod(){
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost("");
		
		CloseableHttpResponse httpResponse = null;
		try {
			httpResponse = closeableHttpClient.execute(httpPost);
			
			logger.info("get baidu response value:{}",httpResponse.getStatusLine().toString());
			
			Header[] headers = httpResponse.getAllHeaders();
			
			for (Header header : headers) {
				logger.info("header name:{},header value:{}",header.getName(),header.getValue());
			}
			
			HttpEntity httpEntity = httpResponse.getEntity();
			
			logger.info("entity tostring:{}",EntityUtils.toString(httpEntity, "UTF-8"));
			
			EntityUtils.consume(httpEntity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (null != httpResponse) {
					httpResponse.close();
				}
				closeableHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testGetMicrosoft() throws MalformedURLException{
		Date date = new Date();
		File file = new File("E:/baozun/temp2");
		
		WebSitemapGenerator sitemapGenerator = WebSitemapGenerator
				.builder("https://www.microsoftstore.com.hk", file).build();
		Set<String> strings = new HashSet<>();
		WebSitemapUrl sitemapUrl;
		try {
			sitemapUrl = new WebSitemapUrl.Options("https://www.microsoftstore.com.hk")
					.lastMod(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).priority(1.0).changeFreq(ChangeFreq.DAILY).build();
			sitemapGenerator.addUrl(sitemapUrl);
			strings.add("https://www.microsoftstore.com.hk");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getMicrosoft("https://www.microsoftstore.com.hk", strings, sitemapGenerator);
		
		sitemapGenerator.write();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.warn("begintime:{},endtime:{}",simpleDateFormat.format(date),simpleDateFormat.format(new Date()));
	}
	
	private void getMicrosoft(String url,Set<String> strings,WebSitemapGenerator sitemapGenerator){
		logger.warn("url:{}",url);
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		
		CloseableHttpResponse httpResponse = null;
		try {
			HttpGet httpGet = new HttpGet(url.replaceAll(" ", "%20"));
			
			httpResponse = closeableHttpClient.execute(httpGet);
			
			HttpEntity httpEntity = httpResponse.getEntity();
			Document document = Jsoup.parse(EntityUtils.toString(httpEntity, "UTF-8"));
			Elements elements = document.getElementsByTag("a");
			if (elements.isEmpty() && strings.contains(url)) {
				return;
			}
			
			Iterator<Element> iterator = elements.iterator();
			while (iterator.hasNext()) {
				Element ahref = iterator.next();
				String href = ahref.attr("href");
				href = href.indexOf("?") == -1 ? href : href.substring(0, href.indexOf("?"));
				href = href.indexOf("#") == -1 ? href : href.substring(0, href.indexOf("#"));
				if (href.endsWith("/")) {
					href = href.substring(0,href.length()-1);
				}
				if (href.contains("%20")) {
					href = href.replace("%20", " ");
				}
				if (StringUtil.isBlank(href) || !href.startsWith("https://www.microsoftstore.com.hk")
						|| strings.contains(href) || href.startsWith("https://www.microsoftstore.com.hk/oauth")
						|| href.startsWith("https://www.microsoftstore.com.hk/account")
						|| href.startsWith("https://www.microsoftstore.com.hk/login")
						|| href.startsWith("https://www.microsoftstore.com.hk/shoppingcart")) {
					continue;
				}
				strings.add(href);
				try {
					Double priority = 1.0;
					if (href.startsWith("https://www.microsoftstore.com.hk/cat/")
							|| href.startsWith("https://www.microsoftstore.com.hk/pages/")) {
						priority = 0.9;
					} else if (href.startsWith("https://www.microsoftstore.com.hk/product/")
							|| href.startsWith("https://www.microsoftstore.com.hk/faq/")) {
						priority = 0.8;
					}
					WebSitemapUrl sitemapUrl = new WebSitemapUrl.Options(href)
							.lastMod(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).priority(priority).changeFreq(ChangeFreq.DAILY).build();
					sitemapGenerator.addUrl(sitemapUrl);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				getMicrosoft(href, strings, sitemapGenerator);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (null != httpResponse) {
					httpResponse.close();
				}
				closeableHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
