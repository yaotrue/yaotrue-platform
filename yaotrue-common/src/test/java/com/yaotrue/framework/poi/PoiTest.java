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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.CellReference;
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
	
	@Test
	public void testSelect() throws Exception{
		List<String> values = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			values.add("张三"+i);
		}
		String[] datas = values.toArray(new String[values.size()]);
		
		List<String> values2 = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			values2.add("李四2"+i);
		}
		String[] datas2 = values2.toArray(new String[values2.size()]);
		
		File file = new File("F://121.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
		
		HSSFSheet hssfSheet = workbook.getSheetAt(0);
		
		HSSFSheet hidden1 = workbook.createSheet("hidden1");
		dropDownList2003(datas, workbook, hssfSheet, hidden1, 0,0,200,1,1);
		HSSFSheet hidden2 = workbook.createSheet("hidden2");
		dropDownList2003(datas2, workbook, hssfSheet, hidden2, 0,0,200,2,2);
		
		FileOutputStream stream = new FileOutputStream("F://234.xls");
		workbook.write(stream);
		stream.close();
	}
	
	public static void dropDownList2003(String[] datas,HSSFWorkbook workbook,HSSFSheet realSheet,HSSFSheet hidden,int hiddenCell,
			int firstRow, int lastRow, int firstCol, int lastCol)
			throws Exception {
		CellStyle style = workbook.createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		HSSFRow row = null;
		HSSFCell cell = null;
		for (int i = 0, length = datas.length; i < length; i++) {
			row = hidden.createRow(i);
			cell = row.createCell(hiddenCell);
			cell.setCellValue(datas[i]);
		}
		
		Name namedCell = workbook.createName();
		namedCell.setNameName(hidden.getSheetName());
		
		namedCell.setRefersToFormula(String.format("%s!%s:%s", hidden.getSheetName(),getCellIndex(0, hiddenCell),getCellIndex(datas.length, hiddenCell)));
		DVConstraint constraint = DVConstraint
				.createFormulaListConstraint(hidden.getSheetName());
		CellRangeAddressList addressList = null;
		HSSFDataValidation validation = null;
		
		addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
		validation = new HSSFDataValidation(addressList, constraint);
		realSheet.addValidationData(validation);
		validation.setShowErrorBox(false);// 取消弹出错误框
	}
	
	public static String getCellIndex(int row, int col){
		CellReference cell = new CellReference(row, col);
		return cell.formatAsString().replaceAll("\\$", "");
	}
	
	@Test
	public void testGetcellIndex(){
		System.out.println(getCellIndex(1, 1));
		System.out.println(String.format("%s!%s:%s", "hidden","A1","A10"));
	}
}
