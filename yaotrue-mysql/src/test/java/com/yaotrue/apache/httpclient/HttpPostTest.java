/*
 * Copyright 1999-2017 YaoTrue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yaotrue.apache.httpclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * @author <a href="mailto:yaotrue@163.com">yaotrue</a>
 * 2017年4月6日 下午5:36:11
 */
public class HttpPostTest {

	@Test
	public void testClient(){
		Map<String, String> map = new HashMap<>();
		map.put("ttt", "aaa");
		map.put("yyy", "qqq");

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost/servlet");
		// 这里使用了对象转为json string
		String json = JSON.toJSONString(map);
		StringEntity entity = new StringEntity("111=111", "UTF-8");
		// NOTE：防止中文乱码
		entity.setContentType("application/json");
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json; charset=UTF-8");
		httpPost.setHeader("Content-type", "application/json; charset=UTF-8");
		try {
			CloseableHttpResponse response = client.execute(httpPost);
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
