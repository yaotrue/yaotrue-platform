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
package com.yaotrue.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年8月11日 上午8:46:08
 */
public class ThreadTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ThreadTest.class);

	public static void main(String[] args) {
		logger.info("主线程{}开始",Thread.currentThread().getName());
		MyThread myThread1 = new MyThread("A");
		MyThread myThread2 = new MyThread("B");
		
		myThread1.start();
		myThread2.start();
		
		try {
			myThread1.join();
			myThread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info("主线程{}结束",Thread.currentThread().getName());
	}
}
