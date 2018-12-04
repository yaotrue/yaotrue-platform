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

import org.junit.Test;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2016年9月1日 上午10:55:29
 */
public class ProxyTest {

	@Test
	public void testProxy(){
//		Hello hello = new SystemOutHello();
		Hello hello = new Log4jHello();
		HelloProxy helloProxy = new HelloProxy(hello);
		helloProxy.sayHello();
	}
	
	@Test
	public void testJdkProxy(){
		JdkProxy<Hello> jdkProxy = new JdkProxy<Hello>();
		Hello hello = jdkProxy.bind(new SystemOutHello());
		hello.sayHello();
	}
}
