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
package com.yaotrue.base.io;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.yaotrue.model.sku.Sku;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年11月22日 下午1:34:23
 */
public class IOTest {

	@Test
	public void testIO(){
		System.out.println(FileUtils.getTempDirectoryPath());
		System.out.println(FileUtils.getUserDirectoryPath());
		System.out.println(FileUtils.byteCountToDisplaySize(new BigInteger(new Integer(1025*1024*1024).toString()).multiply(new BigInteger("54"))));
		
		InputStream inputStream = new StringBufferInputStream("好看哈苏德");
//		inputStream.
	}
	
	@Test
	public void testCollections(){
		List<Sku> skus = new ArrayList<Sku>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Sku sku1 = new Sku();
		try {
			sku1.setOnLineTime(simpleDateFormat.parse("2016-11-23 15:25:45"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sku sku2 = new Sku();
		try {
			sku2.setOnLineTime(simpleDateFormat.parse("2016-11-23 15:26:45"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sku sku3 = new Sku();
		try {
			sku3.setOnLineTime(simpleDateFormat.parse("2016-11-23 12:26:45"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sku sku4 = new Sku();
		try {
			sku4.setOnLineTime(simpleDateFormat.parse("2016-11-23 12:26:45"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		skus.add(sku2);
		skus.add(sku3);
		skus.add(sku1);
		skus.add(sku4);
		
		Collections.sort(skus, new Comparator<Sku>() {
			/* (non-Javadoc)
			 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
			 */
			@Override
			public int compare(Sku o1, Sku o2) {
				if (o1.getOnLineTime().before(o2.getOnLineTime())) {
					return -1;
				}else if (o1.getOnLineTime().after(o2.getOnLineTime())) {
					return 1;
				}
				return 0;
			}
		});
		
		for (Sku sku : skus) {
			System.out.println(simpleDateFormat.format(sku.getOnLineTime()));
		}
	}
}
