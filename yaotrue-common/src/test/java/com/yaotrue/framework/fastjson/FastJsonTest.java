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
package com.yaotrue.framework.fastjson;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年10月27日 下午6:02:56
 */
public class FastJsonTest {
	
	private static final Logger logger = LoggerFactory.getLogger(FastJsonTest.class);

	@Test
	public void testFastJson(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nowTime", new Date());
		params.put("str", "测试");
		params.put("int", 120);
		params.put("double", new Double(123.23));
		
		String string = JSON.toJSONString(params);
		logger.info("fastjson parse result:{}",string);
		
		@SuppressWarnings("unchecked")
		Map<String, Object> jsonToMap = JSON.parseObject(string, HashMap.class);
		for(String key : jsonToMap.keySet()){
			logger.info("key:{},value:{}",new Object[]{key,jsonToMap.get(key)});
		}
	}
}
