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
package com.yaotrue.framework.spring.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yaotrue.BaseTest;
import com.yaotrue.event.EmailEvent;
import com.yaotrue.event.EventPublisher;
import com.yaotrue.manager.sku.SkuManager;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年11月17日 下午1:03:28
 */
public class AsynTest extends BaseTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AsynTest.class);
	
	@Autowired
	private EventPublisher eventPublisher;
	
	@Autowired
	private SkuManager skuManager;

	@Test
	public void testhhh() {
		EmailEvent emailEvent = new EmailEvent(this, "code");
		logger.info("begin");
		eventPublisher.publish(emailEvent);
		logger.info("end");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSyncReturn(){
		
		logger.info("test begin");
		Future<String> future = skuManager.getCodeByAsync();
		
		logger.info("test -----");
		while(true){
			if(future.isDone()){
				try {
					logger.info("result is :{}",future.get());
					break;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			logger.info("continue.....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		logger.info("test end");
	}
}
