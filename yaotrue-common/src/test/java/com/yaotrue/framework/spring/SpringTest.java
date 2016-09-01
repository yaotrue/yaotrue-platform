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

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="mailto:zhen.yao@baozun.cn">zhen.yao</a>
 * 2016年8月31日 上午10:09:01
 */
public class SpringTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringTest.class);
	
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("helloworld.xml");

	@Test
	public void testSayHello(){
		HelloWord helloWord = applicationContext.getBean("hello",HelloWord.class);
		
		helloWord.sayHello();
		
		Map<String, HelloWord> map = applicationContext.getBeansOfType(HelloWord.class);
		
		for(String beanName : map.keySet()){
			logger.info("beanName:{}",beanName);
			map.get(beanName).sayHello();
		}
	}
	
	@Test
	public void testPropertiesInject(){
		Person person = applicationContext.getBean("person",Person.class);
		System.out.println(person.getName());
		for (String yhk : person.getYhk()) {
			System.out.println(yhk);
		}
		for (Double price : person.getPrice()) {
			System.out.println(price);
		}
		for (Integer num : person.getNum()) {
			System.out.println(num);
		}
		
		for(String yhk : person.getYhkPrice().keySet()){
			System.out.println(yhk+":"+person.getYhkPrice().get(yhk));
		}
		Set<Object> objects = person.getProperties().keySet();
		for(Object object : objects){
			System.out.println(object + ":" + person.getProperties().getProperty((String)object));
		}
	}
}
