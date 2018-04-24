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
package com.yaotrue.redis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.SolrPingResponse;
import org.junit.Test;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2018年1月19日 下午1:43:09
 */
public class SolrTest {

	@Test
	public void testSolr(){
		HttpSolrClient httpSolrClient = new HttpSolrClient.Builder("http://localhost:8080/solr/taobaoke").
				withConnectionTimeout(10000).withSocketTimeout(60000).build();
		
		try {
			SolrPingResponse pingResponse = httpSolrClient.ping();
			System.out.println(pingResponse.getStatus());
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsert(){
		String filePath = "E:/solr/self_learn_solr/精选优质商品清单(内含优惠券)-2018-01-19.xls";
		File file = new File(filePath);
		InputStream inp = null;
		HttpSolrClient httpSolrClient = new HttpSolrClient.Builder("http://localhost:8080/solr/taobaoke").
				withConnectionTimeout(10000).withSocketTimeout(60000).build();
		try {
			inp = new FileInputStream(file);
			//根据上述创建的输入流 创建工作簿对象 
	        Workbook wb = WorkbookFactory.create(inp); 
	        //得到第一页 sheet 
	        //页Sheet是从0开始索引的 
	        Sheet sheet = wb.getSheetAt(0);
	        List<Taobaoke> taobaokes = new ArrayList<>();
	        //利用foreach循环 遍历sheet中的所有行 
	        for (Row row : sheet) {
	        	if(row.getRowNum() == 0){
	        		continue;
	        	}
	        	
	        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        	Taobaoke taobaoke = new Taobaoke();
	        	taobaoke.setId(row.getCell(0).getStringCellValue());//商品id
	        	taobaoke.setItemName(row.getCell(1).getStringCellValue());
	        	taobaoke.setItemImage(row.getCell(2).getStringCellValue());
	        	taobaoke.setItemOriginalUrl(row.getCell(3).getStringCellValue());
	        	taobaoke.setItemCategory(row.getCell(4).getStringCellValue());
	        	taobaoke.setItemPrice(Double.valueOf(row.getCell(6).getStringCellValue()));
	        	taobaoke.setItemSales(Integer.parseInt(row.getCell(7).getStringCellValue()));
	        	taobaoke.setItemTbkUrl(row.getCell(5).getStringCellValue());
	        	taobaoke.setPlatformType(row.getCell(13).getStringCellValue());
	        	taobaoke.setShouruBili(Double.valueOf(row.getCell(8).getStringCellValue()));
	        	taobaoke.setYongjin(Double.valueOf(row.getCell(9).getStringCellValue()));
	        	taobaoke.setSellerId(row.getCell(11).getStringCellValue());
	        	taobaoke.setSellerName(row.getCell(10).getStringCellValue());
	        	taobaoke.setShopName(row.getCell(12).getStringCellValue());
	        	taobaoke.setCouponId(row.getCell(14).getStringCellValue());
	        	taobaoke.setCouponBeginTime(dateFormat.parse(row.getCell(18).getStringCellValue()));
	        	taobaoke.setCouponEndTime(dateFormat.parse(row.getCell(19).getStringCellValue()));
	        	taobaoke.setCouponMark(row.getCell(17).getStringCellValue());
	        	taobaoke.setCouponOriginalUrl(row.getCell(20).getStringCellValue());
	        	taobaoke.setCouponTbkUrl(row.getCell(21).getStringCellValue());
	        	taobaokes.add(taobaoke);
	        }
	        httpSolrClient.addBeans(taobaokes);
	        httpSolrClient.commit();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			try {
				inp.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				httpSolrClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
