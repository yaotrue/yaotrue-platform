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

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yaotrue.BaseTest;
import com.yaotrue.manager.util.VelocityManager;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年10月27日 下午4:04:50
 */
public class VelocityManagerTest extends BaseTest {
	
	private static final Logger logger = LoggerFactory.getLogger(VelocityManagerTest.class);

	@Autowired
	private VelocityManager velocityManager;
	
	@Test
	public void testVelocityParseVMContent(){
		Map<String, Object> contextParameters = new HashMap<String, Object>();
		contextParameters.put("str", "测试");
		logger.info("velocity parse result:{}",velocityManager.parseVMContent("str:$str", contextParameters));
	}
	
	@Test
	public void testVelocityParseVMTemplate(){
		Map<String, Object> contextParameters = new HashMap<String, Object>();
		contextParameters.put("str", "测试");
		logger.info("velocity parse result:{}",velocityManager.parseVMTemplate("velocity/test.vm", contextParameters));
	}
}
