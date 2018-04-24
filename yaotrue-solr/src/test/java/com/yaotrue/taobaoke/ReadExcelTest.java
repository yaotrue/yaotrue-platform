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
package com.yaotrue.taobaoke;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2018年1月18日 下午3:35:01
 */
public class ReadExcelTest {

	@Test
	public void testRead(){
		String filePath = "";
		File file = new File(filePath);
		InputStream inp = null;
		try {
			inp = new FileInputStream(file);
			//根据上述创建的输入流 创建工作簿对象 
	        Workbook wb = WorkbookFactory.create(inp); 
	        //得到第一页 sheet 
	        //页Sheet是从0开始索引的 
	        Sheet sheet = wb.getSheetAt(0); 
	        //利用foreach循环 遍历sheet中的所有行 
	        for (Row row : sheet) {
	        	if(row.getRowNum() == 0){
	        		continue;
	        	}
	        		
	        	row.getCell(0).getStringCellValue();//商品id
	        	row.getCell(1).getStringCellValue();//商品名称
	        	row.getCell(2).getStringCellValue();//商品主图
	        	row.getCell(3).getStringCellValue();//商品详情页链接地址
	        	row.getCell(4).getStringCellValue();//商品一级类目
	        	row.getCell(5).getStringCellValue();//淘宝客链接
	        	row.getCell(6).getStringCellValue();//商品价格(单位：元)
	        	row.getCell(7).getStringCellValue();//商品月销量
	        	row.getCell(8).getStringCellValue();//收入比率(%)
	        	row.getCell(9).getStringCellValue();//佣金
	        	row.getCell(10).getStringCellValue();//卖家旺旺
	        	row.getCell(11).getStringCellValue();//卖家id
	        	row.getCell(12).getStringCellValue();//店铺名称
	        	row.getCell(13).getStringCellValue();//平台类型
	        	row.getCell(14).getStringCellValue();//优惠券id
	        	row.getCell(15).getStringCellValue();//优惠券总量
	        	row.getCell(16).getStringCellValue();//优惠券剩余量
	        	row.getCell(17).getStringCellValue();//优惠券面额
	        	row.getCell(18).getStringCellValue();//优惠券开始时间
	        	row.getCell(19).getStringCellValue();//优惠券结束时间
	        	row.getCell(20).getStringCellValue();//优惠券链接
	        	row.getCell(21).getStringCellValue();//商品优惠券推广链接
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
