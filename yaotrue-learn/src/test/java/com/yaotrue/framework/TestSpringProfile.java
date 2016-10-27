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
package com.yaotrue.framework;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.yaotrue.BaseTest;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年10月27日 下午1:47:38
 */
public class TestSpringProfile extends BaseTest {
	
	private static final Logger logger = LoggerFactory.getLogger(TestSpringProfile.class);

	@Value("#{meta['test.jasypt']}")
	private String testStr = "";
	
	@Test
	public void testSpringProfile(){
		logger.info("testStr:{}",testStr);
	}
}
