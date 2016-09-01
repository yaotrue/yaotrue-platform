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
package com.yaotrue.framework.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年8月31日 下午12:25:29
 */
public class HelloWorldLog4j implements HelloWord {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldLog4j.class);
	
	private String str = "hello world";
	
	/**
	 * @param str the str to set
	 */
	public void setStr(String str) {
		this.str = str;
	}

	/**
	 * Creates a new instance of HelloWorldLog4j.
	 */
	public HelloWorldLog4j() {
	}
	
	/**
	 * Creates a new instance of HelloWorldLog4j.
	 */
	public HelloWorldLog4j(String str) {
		this.str = str;
	}

	/* (non-Javadoc)
	 * @see com.yaotrue.framework.spring.HelloWord#sayHello()
	 */
	@Override
	public void sayHello() {
		logger.info(str);
	}

}
