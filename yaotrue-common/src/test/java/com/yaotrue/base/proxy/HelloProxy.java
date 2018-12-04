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
package com.yaotrue.base.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年9月1日 上午10:57:03
 */
public class HelloProxy implements Hello {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloProxy.class);
	
	private Hello hello;

	/**
	 * Creates a new instance of HelloProxy.
	 */
	public HelloProxy(Hello hello) {
		this.hello = hello;
	}
	
	/* (non-Javadoc)
	 * @see com.yaotrue.base.proxy.Hello#sayHello()
	 */
	@Override
	public void sayHello() {
		logger.info("proxy begin");
		hello.sayHello();
		logger.info("proxy end");
	}

}
