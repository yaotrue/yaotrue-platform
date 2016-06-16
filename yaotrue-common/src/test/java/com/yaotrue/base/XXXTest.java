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
package com.yaotrue.base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年5月19日 下午6:13:58
 */
public class XXXTest {
	
	/**
	 * 在所有测试开始之前执行 只会执行一次 修饰的方法必须是共有的静态方法（public static）
	 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
	 * @since JDK 1.7
	 */
	@BeforeClass
	public static void beforeClass(){
		System.out.println("before class");
	}

	/**
	 * 在所有测试结束之后执行 只会执行一次 修饰的方法必须是共有的静态方法（public static）
	 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
	 * @since JDK 1.7
	 */
	@AfterClass
	public static void AfterClass(){
		System.out.println("after class");
	}
	
	/**
	 * 在每个测试方法前执行
	 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
	 * @since JDK 1.7
	 */
	@Before
	public void beforeMethod(){
		System.out.println("before method");
	}
	
	/**
	 * 在每个测试方法后执行
	 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
	 * @since JDK 1.7
	 */
	@After
	public void afterMethod(){
		System.out.println("after method");
	}
	
	@Test(timeout=5/*,expected=RuntimeException.class*/)
	public void testXXX() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("test xxx");
		}
	}

}
