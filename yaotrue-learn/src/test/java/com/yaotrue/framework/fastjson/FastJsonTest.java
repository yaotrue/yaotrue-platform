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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年11月1日 上午9:57:38
 */
public class FastJsonTest {
	
	private static final Logger logger = LoggerFactory.getLogger(FastJsonTest.class);

	@Test
	public void testFastJson(){
		FastJsonModel fastJsonModel = new FastJsonModel();
		fastJsonModel.setBigDecimal(new BigDecimal("54.66"));
		fastJsonModel.setBirthDay(new Date());
		fastJsonModel.setFloat1(85.23f);
		fastJsonModel.setId(120L);
		List<String> listStr = new ArrayList<String>();
		listStr.add("str1");
		listStr.add("str2");
		listStr.add("str3");
		fastJsonModel.setListStr(listStr);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("key1", 10);
		map.put("key2", 20);
		map.put("key3", 30);
		fastJsonModel.setMap(map);
		fastJsonModel.setName("姓名");
		fastJsonModel.setScore(989.666);
		
		String jsonStr = JSON.toJSONString(fastJsonModel);
		logger.info("fastJsonModel parse to json,result:{}",jsonStr);
	}
}
