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
package com.yaotrue.framework.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年11月1日 上午11:48:13
 */
public class PoiTest {
	
	private static final Logger logger = LoggerFactory.getLogger(PoiTest.class);
	
	//使用POI创建excel工作簿 
    public static void createWorkBook() throws IOException { 
        //创建excel工作簿 
        Workbook wb = new HSSFWorkbook(); 
        //创建第一个sheet（页），命名为 new sheet 
        Sheet sheet = wb.createSheet("new sheet"); 
        //Row 行 
        //Cell 方格 
        // Row 和 Cell 都是从0开始计数的 
         
        // 创建一行，在页sheet上 
        Row row = sheet.createRow((short) 0); 
        // 在row行上创建一个方格 
        Cell cell = row.createCell(0); 
        //设置方格的显示 
        cell.setCellValue(1); 
 
        // Or do it on one line. 
        row.createCell(1).setCellValue(1.2); 
        row.createCell(2).setCellValue("This is a string 速度反馈链接"); 
        row.createCell(3).setCellValue(true); 
 
        //创建一个文件 命名为workbook.xls 
        FileOutputStream fileOut = new FileOutputStream("workbook.xls"); 
        // 把上面创建的工作簿输出到文件中 
        wb.write(fileOut); 
        //关闭输出流 
        fileOut.close(); 
    } 
 
    //使用POI读入excel工作簿文件 
    public static void readWorkBook(String filePath) throws Exception { 
        // poi读取excel
        //创建要读入的文件的输入流 
        InputStream inp = new FileInputStream(filePath); 
         
        //根据上述创建的输入流 创建工作簿对象 
        Workbook wb = WorkbookFactory.create(inp); 
        //得到第一页 sheet 
        //页Sheet是从0开始索引的 
        Sheet sheet = wb.getSheetAt(0); 
        //利用foreach循环 遍历sheet中的所有行 
        for (Row row : sheet) {
        	logger.info("cell 1 content:{}",row.getCell(1).getStringCellValue());
            /*//遍历row中的所有方格 
            for (Cell cell : row) { 
                //输出方格中的内容，以空格间隔 
                System.out.print(cell.toString() + "  "); 
            } 
            //每一个行输出之后换行 
            System.out.println(); */
        } 
        //关闭输入流 
        inp.close(); 
    } 

	@Test
	public void testPoi(){
		try {
			readWorkBook("E:/Me/life/长见识/精选优质商品清单(内含优惠券)-2016-11-01.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
