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

import java.util.StringTokenizer;

import org.junit.Test;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年8月30日 下午3:22:36
 */
public class StringTokenizerTest {

	@Test
	public void testStringTokenizer(){
		StringTokenizer stringTokenizer = new StringTokenizer("AES/TEST/HHH", "/",true);
		
		while (stringTokenizer.hasMoreElements()) {
			String str = stringTokenizer.nextToken();
			System.out.println(str);
		}
	}
}
