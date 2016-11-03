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
package com.yaotrue.manager.sku;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yaotrue.command.web.ControllerJsonResponceCommand;
import com.yaotrue.dao.SkuDao;
import com.yaotrue.model.sku.Sku;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年11月1日 下午2:15:52
 */
@Service
@Transactional
public class SkuManagerImpl implements SkuManager {
	
	private static final Logger logger = LoggerFactory.getLogger(SkuManagerImpl.class);
	
	@Autowired
	private SkuDao skuDao;

	/* (non-Javadoc)
	 * @see com.yaotrue.manager.sku.SkuManager#saveSkuByFile(java.io.File)
	 */
	@Override
	public ControllerJsonResponceCommand saveSkuByFile(File file) {
		// poi读取excel
        //创建要读入的文件的输入流 
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
	        	logger.info("cell 1 content:{}",row.getCell(1).getStringCellValue());
	        	
	        	Sku sku = skuDao.getBySkuId(row.getCell(0).getStringCellValue());
	        	if(null == sku){
	        		sku = new Sku();
	        		sku.setSkuId(row.getCell(0).getStringCellValue());
	        	}
	        	sku.setCategoryName(row.getCell(4).getStringCellValue());
	        	sku.setCommission(Double.valueOf(row.getCell(9).getStringCellValue()));
	        	sku.setIncomeRate(Double.valueOf(row.getCell(8).getStringCellValue()));
	        	sku.setPlatformName(row.getCell(13).getStringCellValue());
	        	sku.setPrice(Double.valueOf(row.getCell(6).getStringCellValue()));
	        	sku.setSalesCount(Integer.parseInt(row.getCell(7).getStringCellValue()));
	        	sku.setShopName(row.getCell(12).getStringCellValue());
	        	sku.setSkuDetailUrl(row.getCell(3).getStringCellValue());
	        	sku.setSkuImgUrl(row.getCell(2).getStringCellValue());
	        	sku.setSkuName(row.getCell(1).getStringCellValue());
	        	sku.setTgUrl(row.getCell(5).getStringCellValue());
	        	
	        	skuDao.saveSku(sku);
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//关闭输入流 
	        try {
				inp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
