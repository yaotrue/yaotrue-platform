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

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年5月24日 下午2:05:36
 */
public class Log4jTest {

	private static final Logger logger = Logger.getLogger(Log4jTest.class);
	
	@Test
	public void testLog4j(){
		int i = 2000;
		while(i>0){
			logger.debug("我是一只DEBUG的小青蛙");
			logger.info("呀呀呀呀呀呀呀~我是Info咿呀呀");
			logger.warn("动次打次~WARN~");
			logger.error("爱我别走~如果说ERROR");
			i--;
		}
	}
}
