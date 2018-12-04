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
package com.yaotrue.base.jdkutil;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年6月22日 下午4:29:29
 */
public class UUIDTest {

	private static final Logger logger = LoggerFactory.getLogger(UUIDTest.class);
	
	@Test
	public void testUUID(){
		UUID uuid = UUID.randomUUID();
		logger.info("uuid random value:{}",uuid);
		
		int a[] = new int[100];
		Arrays.copyOf(a, a.length);
		String string = "hello hhh";
		System.out.println(string.codePointCount(0, string.length()));
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
	}
}
